package com.catalog.agregates;

import com.catalog.common.abstractions.Result;
import lombok.*;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class ProductDomain {

    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imageUrl;

    private String categoryId;

    public static Result<ProductDomain> create(String name, Double price, String description, Integer stock,
            String imageUrl, String categoryId) {
        if (name == null || name.isBlank())
            return Result.failure("El nombre es obligatorio");
        if (price == null || price < 0)
            return Result.failure("El precio no puede ser negativo");
        if (stock == null || stock < 0)
            return Result.failure("El stock inicial no puede ser negativo");

        ProductDomain product = ProductDomain.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .price(price)
                .description(description)
                .stock(stock)
                .imageUrl(imageUrl)
                .categoryId(categoryId)
                .build();

        return Result.success(product);
    }

    public Result<Void> assignCategory(String categoryId) {
        if (categoryId == null || categoryId.isBlank()) {
            return Result.failure("La categoría es obligatoria");
        }
        this.categoryId = categoryId;
        return Result.success(null);
    }

    public Result<Void> updateStock(Integer quantity) {
     
        if (quantity == null || quantity < 0) {
            return Result.failure("La cantidad a restar no puede ser negativa");
        }

        int nuevoStock = this.stock - quantity;

        if (nuevoStock < 0) {
            return Result.failure("Stock insuficiente. No se puede quedar en negativo.");
        }

        this.stock = nuevoStock;
        return Result.success(null);
    }

    public Result<Void> update(String name, Double price, String description, Integer stock, String imageUrl,
            String categoryId) {
        // Validaciones de negocio
        if (name == null || name.isBlank())
            return Result.failure("El nombre es obligatorio");
        if (price == null || price < 0)
            return Result.failure("El precio no puede ser negativo");
        if (stock == null || stock < 0)
            return Result.failure("El stock no puede ser negativo");
        if (categoryId == null || categoryId.isBlank())
            return Result.failure("La categoría es obligatoria");
        
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;

        return Result.success(null);
    }

}