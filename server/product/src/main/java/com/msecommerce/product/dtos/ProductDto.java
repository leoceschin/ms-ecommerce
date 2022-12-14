package com.msecommerce.product.dtos;

import jakarta.annotation.Nonnull;

public class ProductDto {
    
    @Nonnull
    private String name;
    @Nonnull
    private Double price;
    @Nonnull
    private String description;

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

    
}
