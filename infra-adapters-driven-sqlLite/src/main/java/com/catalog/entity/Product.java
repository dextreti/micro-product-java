package com.catalog.entity;

import jakarta.persistence.*;
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
@Entity 
@Table(name = "Product")
public class Product {
    
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
    private Category category;
        
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imageUrl;
}