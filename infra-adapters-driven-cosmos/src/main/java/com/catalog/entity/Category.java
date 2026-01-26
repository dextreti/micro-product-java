package com.catalog.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "Category") 
public class Category {
    private String id;
    private String description;
}
