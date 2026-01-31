package com.catalog.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product", schema = "catalog")
public class Product extends PanacheEntityBase {
    
    @Id
    public String id;
    
    public String name;
    
    public String description;
    
    @Column(name = "imageurl") 
    public String imageUrl;
    
    public Double price; 
    
    public Integer stock;
    
    @Column(name = "categoryid", nullable = false)
    public String categoryId;
}
