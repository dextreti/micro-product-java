package com.catalog.mapper;

import org.mapstruct.Mapper;

import com.catalog.agregates.ProductDomain;
import com.catalog.common.abstractions.IGenericMapper;
import com.catalog.entity.Product;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ICategorySqlLiteMapper.class})
public interface IProductSqlLiteMapper extends IGenericMapper<ProductDomain,Product> {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "category.id", source = "categoryId")
    Product toEntity(ProductDomain domain);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDomain toDomain(Product entity);

}
