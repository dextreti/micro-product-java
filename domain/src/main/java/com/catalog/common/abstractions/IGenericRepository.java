package com.catalog.common.abstractions;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {
    void save(T entity);    
    void delete(String id);
    Optional<T> findById(String id);
    List<T> findAll(int page, int size);
}
