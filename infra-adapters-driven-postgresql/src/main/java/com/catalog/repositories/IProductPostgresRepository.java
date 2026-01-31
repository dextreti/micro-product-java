package com.catalog.repositories;

import com.catalog.entities.Product;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IProductPostgresRepository implements  PanacheRepositoryBase<Product, String> {

}
