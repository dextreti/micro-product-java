package com.catalog.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.catalog.agregates.CategoryDomain;
import com.catalog.entity.Category;
import lombok.RequiredArgsConstructor;
import com.catalog.mapper.ICategorySqlLiteMapper;
import com.catalog.ports.out.ICategoryRepository;
import com.catalog.repository.ICategorySqlLiteRepository;

@Component
@RequiredArgsConstructor
public class CategorySqlLiteAdapter implements ICategoryRepository {

    private final ICategorySqlLiteRepository categoryRepository;
    private final ICategorySqlLiteMapper categoryMapper;
    @Override
    public void save(CategoryDomain domain) {

        Category entity = categoryMapper.toEntity(domain);
        categoryRepository.save(entity);
    } 

    @Override
    public void delete(String id) {

        categoryRepository.deleteById(id);

    }

    @Override
    public Optional<CategoryDomain> findById(String id) {

        Optional<Category> categoryOpt = categoryRepository.findById(id);
        return categoryOpt.map(category -> categoryMapper.toDomain(category));

    }

    @Override
    public List<CategoryDomain> findAll(int page, int size) {

        return categoryRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(categoryMapper::toDomain)
                .collect(Collectors.toList());
        
    }
    

}