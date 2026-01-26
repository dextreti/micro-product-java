package com.catalog.repository;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;

import com.catalog.entity.Product;

@Repository
public interface ICosmosProductRepository extends CosmosRepository<Product, String> {
    
    @Query("SELECT * FROM c WHERE c.type = 'PRODUCT'")
    Slice<Product> findAllProducts(Pageable pageable);

    @Query("SELECT * FROM c WHERE c.type = 'PRODUCT' AND c.id = @id")
    Optional<Product> findProductById(String id);

    @Query("SELECT * FROM c WHERE c.type = 'PRODUCT' AND c.categoryId = @categoryId")
    Optional<Product> findByCategoryId(String categoryId);
    
    
}

