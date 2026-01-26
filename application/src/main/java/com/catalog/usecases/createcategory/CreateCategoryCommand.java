package com.catalog.usecases.createcategory;


public record CreateCategoryCommand( 
    String name,
    String description
) {}
