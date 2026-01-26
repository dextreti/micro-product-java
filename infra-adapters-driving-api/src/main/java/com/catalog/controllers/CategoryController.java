package com.catalog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.catalog.usecases.createcategory.CreateCategoryCommand;
import com.catalog.usecases.createcategory.ICreateCategoryUseCase;

@RequestMapping("/api/category")
@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final ICreateCategoryUseCase createCategoryUseCase;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCategoryCommand command) {
        var result = createCategoryUseCase.execute(command);
        
        if (result.isSuccess()) {
            
            return ResponseEntity.status(201).body(result.getValue());
        }

        
        return ResponseEntity.badRequest().body(result.getError());
    }    


}
