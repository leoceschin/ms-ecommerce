package com.msecommerce.inventory.dtos;

import java.io.Serializable;
import java.util.UUID;

public class ProductDto {

    //private static final long serialVersionUID = 1L;
    
    private UUID id;
    private String name;
    private Double price;
    private String description;
    private int quantity;

    public ProductDto() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    
}
