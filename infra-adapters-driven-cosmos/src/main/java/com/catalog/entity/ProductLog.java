package com.catalog.entity;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

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
public class ProductLog {
    @Id
    private String id; 
    
    // SDK sepa que es la Partition Key
    @PartitionKey
    private String categoryId; 

    @Builder.Default
    private String type = "LOG"; 
    
    private String productId; 
    private String userId;    // El ID del responsable
    private String action;    // UPDATE, CREATE
    private String details;   // Cambio de precio"
    private String timestamp; // Fecha en acction
}
