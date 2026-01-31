package com.catalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.catalog.agregates.ProductDomain;
import com.catalog.entities.Product;


@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface ProductMapper {
        
    ProductDomain toDomain(Product entity);

    @Mapping(target = "persistent", ignore = true) 
    Product toEntity(ProductDomain domain);
}
