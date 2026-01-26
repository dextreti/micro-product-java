package com.catalog.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.azure.cosmos.CosmosContainer;

import com.catalog.agregates.CategoryDomain;
import com.catalog.entity.Category;
import lombok.RequiredArgsConstructor;
import com.catalog.mapper.ICategoryCosmoMapper;
import com.catalog.ports.out.ICategoryRepository;
import com.catalog.repository.ICosmosCategoryRepository;

@Component 
@RequiredArgsConstructor
public class CategoryCosmosAdapter implements ICategoryRepository {
    
    private final ICosmosCategoryRepository repository;     
    private final ICategoryCosmoMapper categoryMapper;

    //@Qualifier("categoryContainer")
    //private final CosmosContainer productsContainer;

     @Override
    public void save(CategoryDomain entity) {
              Category category = categoryMapper.toEntity(entity);
              repository.save(category);
    }  
    

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<CategoryDomain> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<CategoryDomain> findAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

   

}
