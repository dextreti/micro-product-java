package com.catalog.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Container(containerName = "Product", partitionKeyPath = "/categoryId") 
public class Product {
    @Id
    private String id;
    
    @PartitionKey
    private String categoryId;
    
    /* para Cosmos DB, añadimos un campo "type" para diferenciar tipos de documentos
       aqui lo usamos para identificar si es el log cuando modificamos el producto
       el diseño tiene un enfoque distinto a una base de datos relacional */
    
    @Builder.Default 
    private String type = "PRODUCT"; 
    
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imageUrl;
}