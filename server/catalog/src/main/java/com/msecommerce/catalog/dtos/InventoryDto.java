package com.msecommerce.catalog.dtos;

import java.util.UUID;

public class InventoryDto {
    private UUID id;
    private int quantity;
    
    public InventoryDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
