package com.catalog.mapper;

import com.catalog.agregates.CategoryDomain;
import com.catalog.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-24T09:15:01-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Debian)"
)
@Component
public class ICategoryCosmoMapperImpl implements ICategoryCosmoMapper {

    @Override
    public Category toEntity(CategoryDomain arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( arg0.getId() );
        category.setDescription( arg0.getDescription() );

        return category;
    }

    @Override
    public CategoryDomain toDomain(Category arg0) {
        if ( arg0 == null ) {
            return null;
        }

        CategoryDomain.CategoryDomainBuilder categoryDomain = CategoryDomain.builder();

        categoryDomain.id( arg0.getId() );
        categoryDomain.description( arg0.getDescription() );

        return categoryDomain.build();
    }
}
