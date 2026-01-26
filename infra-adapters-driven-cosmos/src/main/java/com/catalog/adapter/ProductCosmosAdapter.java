package com.catalog.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosBatch;
import com.azure.cosmos.models.CosmosBatchResponse;
import com.azure.cosmos.models.PartitionKey;

import com.catalog.agregates.ProductDomain;
import com.catalog.entity.Product;
import com.catalog.entity.ProductLog;
import lombok.RequiredArgsConstructor;
import com.catalog.mapper.IProductCosmoMapper;
import com.catalog.ports.out.IProductRepository;
import com.catalog.repository.ICosmosProductRepository;

import org.springframework.data.domain.Pageable;

@Component
@AllArgsConstructor
public class ProductCosmosAdapter implements IProductRepository {

    private final ICosmosProductRepository repository;
    private final IProductCosmoMapper productMapper;

    private final CosmosContainer productsContainer;

    @Override
    public List<ProductDomain> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllProducts(pageable)
                .getContent()
                .stream()
                .map(productMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<ProductDomain> findById(String id) {

        return repository
                .findProductById(id)
                .map(productMapper::toDomain);
    }

    @Override
    public List<ProductDomain> findByCategoryId(String categoryId) {
        return repository.findByCategoryId(categoryId)
                .stream()
                .map(productMapper::toDomain)
                .toList();
    }

    @Override
    public void save(ProductDomain product) {

        Product entity = productMapper.toEntity(product);
        entity.setType("PRODUCT");

        ProductLog log = createLog(entity, "PERSIST_CHANGE", "Cambio sincronizado desde el dominio");

        executeBatch(entity, log);

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private ProductLog createLog(Product entity, String action, String details) {
        return ProductLog.builder()
                .id(UUID.randomUUID().toString())
                .categoryId(entity.getCategoryId())
                .type("LOG")
                .productId(entity.getId())
                .userId("SYSTEM_USER")// SYSTEM_USER solo es una demostración por eso se puso asi
                .action(action)
                .details(details)
                .timestamp(java.time.Instant.now().toString())
                .build();
    }

    private void executeBatch(Product productEntity, ProductLog logEntity) {
        PartitionKey pk = new PartitionKey(productEntity.getCategoryId());
        CosmosBatch batch = CosmosBatch.createCosmosBatch(pk);

        batch.upsertItemOperation(productEntity);

        batch.createItemOperation(logEntity);

        try {
            CosmosBatchResponse response = productsContainer.executeCosmosBatch(batch);
            if (!response.isSuccessStatusCode()) {
                throw new RuntimeException("Error en Batch CosmosDB. Status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // log error técnico
            throw e;
        }
    }

    
}