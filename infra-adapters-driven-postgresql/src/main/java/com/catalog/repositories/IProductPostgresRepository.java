package com.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.entities.Product;


@Repository
public interface IProductPostgresRepository extends JpaRepository<Product, String> {

}
