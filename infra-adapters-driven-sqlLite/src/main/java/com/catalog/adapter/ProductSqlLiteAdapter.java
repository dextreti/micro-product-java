package com.catalog.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.catalog.repository.ICategorySqlLiteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.catalog.agregates.ProductDomain;
import com.catalog.entity.Product;
import lombok.RequiredArgsConstructor;
import com.catalog.mapper.IProductSqlLiteMapper;
import com.catalog.ports.out.IProductRepository;
import com.catalog.repository.IProductSqlLiteRepository;

@Component
@RequiredArgsConstructor 
public class ProductSqlLiteAdapter implements IProductRepository  {
    private final IProductSqlLiteRepository jpaRepository;
    private final IProductSqlLiteMapper productMapper;
    private final ICategorySqlLiteRepository categorySqlLiteRepository;

     @Override
    public List<ProductDomain> findAll(int page, int size) {
              return jpaRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(productMapper::toDomain)
                .collect(Collectors.toList());
    }   

    @Override
    public void save(ProductDomain domain) {
        Product product = productMapper.toEntity(domain);

        if (domain.getCategoryId() != null) {
            var category = categorySqlLiteRepository.findById(domain.getCategoryId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Categoría no encontrada con ID: " + domain.getCategoryId())
                    );
            product.setCategory(category);
        }

        jpaRepository.save(product);
    }  

   

    @Override
    public void delete(String id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<ProductDomain> findById(String id) {
        return jpaRepository.findById(id)
                .map(productMapper::toDomain);
    }

    
    
}
