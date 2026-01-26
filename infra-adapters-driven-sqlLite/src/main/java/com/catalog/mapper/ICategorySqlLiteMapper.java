package com.catalog.mapper;

import org.mapstruct.Mapper;

import com.catalog.agregates.CategoryDomain;
import com.catalog.common.abstractions.IGenericMapper;
import com.catalog.entity.Category;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICategorySqlLiteMapper extends IGenericMapper<CategoryDomain,Category> {

}
