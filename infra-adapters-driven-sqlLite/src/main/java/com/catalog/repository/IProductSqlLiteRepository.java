package com.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.entity.Product;

@Repository
public interface IProductSqlLiteRepository extends JpaRepository<Product, String> {
    List<Product> findByCategoryId(String categoryId);

}
