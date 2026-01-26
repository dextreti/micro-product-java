package com.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalog.entity.Category;

public interface ICategorySqlLiteRepository extends JpaRepository<Category, String> {

}
