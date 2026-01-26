package com.catalog.repository;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import com.catalog.entity.Category;

@Repository
public interface ICosmosCategoryRepository extends CosmosRepository<Category, String> {


}
