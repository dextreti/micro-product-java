package com.catalog.agregates;

import com.catalog.common.abstractions.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDomain {

    private String id;
    private String description;

    /**
     * Factory Method para crear una nueva Categoría.
     * Garantizar que la categoría nazca en un estado válido.
     */
    public static Result<CategoryDomain> create(String name, String description) {
        if (name == null || name.isBlank()) {
            return Result.failure("El nombre de la categoría es obligatorio");
        }

        if (description == null || description.length() < 10) {
            return Result.failure("La descripción debe tener al menos 10 caracteres");
        }

        CategoryDomain category = CategoryDomain.builder()
                .id(UUID.randomUUID().toString())
                .description(description)
                .build();

        return Result.success(category);
    }


    public Result<Void> updateName(String newName) {
        if (newName == null || newName.isBlank()) {
            return Result.failure("El nuevo description no puede estar vacío");
        }
        this.description = newName;
        return Result.success(null);
    }
}