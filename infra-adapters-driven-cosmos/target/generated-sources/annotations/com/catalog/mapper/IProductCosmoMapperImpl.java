package com.catalog.mapper;

import com.catalog.agregates.ProductDomain;
import com.catalog.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-24T09:15:00-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Debian)"
)
@Component
public class IProductCosmoMapperImpl implements IProductCosmoMapper {

    @Override
    public Product toEntity(ProductDomain domain) {
        if ( domain == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( domain.getId() );
        product.categoryId( domain.getCategoryId() );
        product.name( domain.getName() );
        product.description( domain.getDescription() );
        product.price( domain.getPrice() );
        product.stock( domain.getStock() );
        product.imageUrl( domain.getImageUrl() );

        return product.build();
    }

    @Override
    public ProductDomain toDomain(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDomain.ProductDomainBuilder productDomain = ProductDomain.builder();

        productDomain.id( entity.getId() );
        productDomain.name( entity.getName() );
        productDomain.description( entity.getDescription() );
        productDomain.price( entity.getPrice() );
        productDomain.stock( entity.getStock() );
        productDomain.imageUrl( entity.getImageUrl() );
        productDomain.categoryId( entity.getCategoryId() );

        return productDomain.build();
    }
}
