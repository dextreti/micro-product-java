package com.catalog.mapper;

import org.mapstruct.Mapper;

import com.catalog.agregates.CategoryDomain;
import com.catalog.common.abstractions.IGenericMapper;
import com.catalog.entity.Category;

@Mapper(componentModel = "spring")
public interface ICategoryCosmoMapper extends IGenericMapper<CategoryDomain, Category> {
    
}