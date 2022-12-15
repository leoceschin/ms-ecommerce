package com.msecommerce.inventory.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.msecommerce.inventory.dtos.ProductDto;
import com.msecommerce.inventory.services.impl.InventoryServiceImpl;

@Component
public class InsertInventorytListener {
    
    @Autowired
    InventoryServiceImpl inventoryService;

    @RabbitListener(queues = "INSERT-PRODUCT-QUEUE")
    public void insertInventory(ProductDto productDto){
        inventoryService.updateInventory(productDto);
    }

}
