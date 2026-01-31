package com.catalog.entities;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product", schema = "product_catalog")
public class Product {
    
    @Id
    public String id;
    
    public String name;
    
    public String description;       
    
    public BigDecimal price; 
    
    public Integer stock;
    
    @Column(name = "categoryid", nullable = false)
    public String categoryId;

    @ManyToOne
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private Category category; 


}
