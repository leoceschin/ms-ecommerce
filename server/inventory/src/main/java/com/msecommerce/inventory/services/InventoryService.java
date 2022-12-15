package com.msecommerce.inventory.services;

import org.springframework.stereotype.Service;

import com.msecommerce.inventory.dtos.ProductDto;
import com.msecommerce.inventory.models.ProductInventory;

@Service
public interface InventoryService {
    ProductInventory updateInventory(ProductDto productDto);
}
