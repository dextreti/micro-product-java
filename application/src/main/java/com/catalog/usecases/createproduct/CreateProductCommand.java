package com.catalog.usecases.createproduct;

public record CreateProductCommand(
    String name,
    Double price,
    String description,
    Integer stock,
    String imageUrl,
    String categoryId
) {}
