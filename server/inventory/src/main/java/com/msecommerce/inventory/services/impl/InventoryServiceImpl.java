package com.msecommerce.inventory.services.impl;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msecommerce.inventory.dtos.InventoryDto;
import com.msecommerce.inventory.dtos.ProductDto;
import com.msecommerce.inventory.models.ProductInventory;
import com.msecommerce.inventory.repositories.InventoryRepository;
import com.msecommerce.inventory.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;


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
        InventoryDto inventoryDto = new InventoryDto();
        BeanUtils.copyProperties(productInventory, inventoryDto);
        rabbitTemplate.convertAndSend("products.v1.sender","update-inventory-queue", inventoryDto);
        return productInventory;
        
    }
    
}
