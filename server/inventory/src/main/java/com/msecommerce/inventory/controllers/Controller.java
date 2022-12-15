package com.msecommerce.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msecommerce.inventory.dtos.ProductDto;
import com.msecommerce.inventory.models.ProductInventory;
import com.msecommerce.inventory.services.impl.InventoryServiceImpl;

@RestController
public class Controller {
    
    @Autowired
    InventoryServiceImpl inventoryService;

    @PutMapping("/update-inventory/{id}")
    public ResponseEntity<ProductInventory> updateInventory(ProductDto productDto){
        return ResponseEntity.ok(inventoryService.updateInventory(productDto));
    }
}
