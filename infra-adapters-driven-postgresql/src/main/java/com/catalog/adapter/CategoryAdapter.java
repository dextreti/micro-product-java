package com.catalog.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.catalog.agregates.CategoryDomain;
import com.catalog.entities.Category;
import com.catalog.ports.out.ICategoryRepository;
import com.catalog.repositories.ICategoryPostgresqlRepository;

@Repository
public class CategoryAdapter implements ICategoryRepository {

    private final ICategoryPostgresqlRepository repository;

    // Constructor para inyección de dependencia
    public CategoryAdapter(ICategoryPostgresqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(CategoryDomain domain) {
        Category entity = Category.builder()
                .id(domain.getId())
                .description(domain.getDescription())
                .build();
        
        repository.save(entity);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<CategoryDomain> findById(String id) {
        return repository.findById(id)
                .map(entity -> new CategoryDomain(entity.getId(), entity.getDescription()));
    }

    @Override
    public List<CategoryDomain> findAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


}
