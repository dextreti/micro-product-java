package com.catalog.common.abstractions;

public interface IGenericMapper<TDomain, TEntity> {

    TEntity toEntity(TDomain domain);    
    TDomain toDomain(TEntity entity);

}

