package com.catalog.mapper;

import com.catalog.agregates.ProductDomain;
import com.catalog.entity.Category;
import com.catalog.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-24T09:15:03-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Debian)"
)
@Component
public class IProductSqlLiteMapperImpl implements IProductSqlLiteMapper {

    @Override
    public Product toEntity(ProductDomain domain) {
        if ( domain == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.category( productDomainToCategory( domain ) );
        product.id( domain.getId() );
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

        productDomain.categoryId( entityCategoryId( entity ) );
        productDomain.id( entity.getId() );
        productDomain.name( entity.getName() );
        productDomain.description( entity.getDescription() );
        productDomain.price( entity.getPrice() );
        productDomain.stock( entity.getStock() );
        productDomain.imageUrl( entity.getImageUrl() );

        return productDomain.build();
    }

    protected Category productDomainToCategory(ProductDomain productDomain) {
        if ( productDomain == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( productDomain.getCategoryId() );

        return category.build();
    }

    private String entityCategoryId(Product product) {
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getId();
    }
}
