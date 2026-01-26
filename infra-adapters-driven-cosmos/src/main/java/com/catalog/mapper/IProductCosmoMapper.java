package com.catalog.mapper;

import org.mapstruct.Mapper;

import com.catalog.agregates.ProductDomain;
import com.catalog.entity.Product;

@Mapper(componentModel = "spring", uses = {ICategoryCosmoMapper.class})
public interface IProductCosmoMapper {
    
    Product toEntity(ProductDomain domain);

    ProductDomain toDomain(Product entity);

}