package com.catalog.adapter;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;


import java.util.List;
import java.util.Optional;

import com.catalog.agregates.ProductDomain;
import com.catalog.entities.Product;
import com.catalog.mapper.IProductMapper;
import com.catalog.ports.out.IProductRepository;
import com.catalog.repositories.IProductPostgresRepository;

import lombok.RequiredArgsConstructor;

@Component 
@RequiredArgsConstructor
public class ProductAdapter implements IProductRepository {

    private final IProductPostgresRepository repository;
    private final IProductMapper mapper; 

    @Override
    @Transactional 
    public void save(ProductDomain productDomain) {
        Product productEntity = mapper.toEntity(productDomain);        
        repository.save(productEntity); 
    }

    @Override
    public Optional<ProductDomain> findById(String id) {
        
        return repository.findById(id)
                     .map(mapper::toDomain);
    }

    @Override
    public List<ProductDomain> findAll(int page, int size) {
        
        return repository.findAll(PageRequest.of(page, size))
                         .getContent()
                         .stream()
                         .map(mapper::toDomain)
                         .toList();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    
}
