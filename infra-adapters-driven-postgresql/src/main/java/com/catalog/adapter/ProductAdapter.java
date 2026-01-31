package com.catalog.adapter;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import com.catalog.agregates.ProductDomain;
import com.catalog.entities.Product;

import com.catalog.mapper.ProductMapper;
import com.catalog.ports.out.IProductRepository;
import com.catalog.repositories.IProductPostgresRepository;

@ApplicationScoped 
public class ProductAdapter implements IProductRepository {

    @Inject
    IProductPostgresRepository repository; 

    @Inject
    ProductMapper mapper; 

    @Override
    @Transactional 
    public void save(ProductDomain productDomain) {
        
        Product productEntity = mapper.toEntity(productDomain);        
        repository.persist(productEntity);
    }

    @Override
    public Optional<ProductDomain> findById(String id) {

      return repository.findByIdOptional(id)
                     .map(entity -> mapper.toDomain(entity));
    }

    @Override
    public List<ProductDomain> findAll(int page, int size) {
        
        return repository.findAll()
                         .page(page, size)
                         .list()
                         .stream()
                         .map(mapper::toDomain)
                         .toList();
    }

    @Override
    public void delete(String arg0) {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");

    }

    @Override
    public List<ProductDomain> findByCategoryId(String arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCategoryId'");
    }

    
}
