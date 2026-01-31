package com.catalog.mapper;

import org.mapstruct.Mapper;


import com.catalog.agregates.ProductDomain;
import com.catalog.common.abstractions.IGenericMapper;
import com.catalog.entities.Product;


@Mapper(componentModel = "spring")
public interface IProductMapper extends IGenericMapper<ProductDomain,Product> {
        
    ProductDomain toDomain(Product entity);
    
    Product toEntity(ProductDomain domain);

    
    
}
