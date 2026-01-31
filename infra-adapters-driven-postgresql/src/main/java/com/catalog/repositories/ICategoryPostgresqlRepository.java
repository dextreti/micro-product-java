package com.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalog.entities.Category;

public interface ICategoryPostgresqlRepository extends JpaRepository<Category, String> {

}
