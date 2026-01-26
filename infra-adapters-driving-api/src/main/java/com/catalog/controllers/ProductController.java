package com.catalog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.catalog.usecases.createproduct.CreateProductCommand;
import com.catalog.usecases.createproduct.ICreateProductUseCase;
import com.catalog.usecases.updateproduct.IUpdateProductUseCase;
import com.catalog.usecases.updateproduct.UpdateProductCommand;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ICreateProductUseCase createProductUseCase;
    private final IUpdateProductUseCase updateProductUseCase;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductCommand command) {
        var result = createProductUseCase.execute(command);
        
        if (result.isSuccess()) {

            return ResponseEntity.status(201).body(result.getValue());
        }

        return ResponseEntity.badRequest().body(result.getError());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdateProductCommand command) {

        var result = updateProductUseCase.execute(command, id);

        if (result.isSuccess()) {
            // 4. Devolvemos 200 OK para actualizaciones exitosas
            return ResponseEntity.ok(result.getValue());
        }

        // Si falla (por ejemplo, producto no encontrado), devolvemos el error
        return ResponseEntity.badRequest().body(result.getError());
    }
    
    
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody UpdateProductCommand cmd, @PathVariable String id) {
//        var result = updateProductUseCase.execute(cmd, id);
//
//        if (result.isSuccess()) {
//            // Devolvemos 201 Created y el ID del producto en el cuerpo (o el objeto)
//            return ResponseEntity.status(201).body(result.getValue());
//        }
//
//        // Si falla, devolvemos el error específico que viene del Dominio
//        return ResponseEntity.badRequest().body(result.getError());
//    }
}