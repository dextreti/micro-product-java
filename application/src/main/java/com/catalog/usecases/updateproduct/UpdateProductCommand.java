package com.catalog.usecases.updateproduct;

public record UpdateProductCommand(
    String name,
    Double price,
    String description,
    Integer stock,
    String imageUrl,
    String categoryId
) {   

}
