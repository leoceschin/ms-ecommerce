package com.msecommerce.inventory.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msecommerce.inventory.dtos.ProductDto;
import com.msecommerce.inventory.models.ProductInventory;
import com.msecommerce.inventory.repositories.InventoryRepository;
import com.msecommerce.inventory.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public ProductInventory updateInventory(ProductDto productDto) {
        ProductInventory productInventory = new ProductInventory();
        Optional<ProductInventory> optionalInventory = inventoryRepository.findById(productDto.getId());
        if(!optionalInventory.isPresent()){
            productInventory.setId(productDto.getId());
            productInventory.setQuantity(productDto.getQuantity());
            inventoryRepository.save(productInventory);
        }else{
            productInventory = optionalInventory.get();

        }
        return productInventory;
        
    }
    
}
