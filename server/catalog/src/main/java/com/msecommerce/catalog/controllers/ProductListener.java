package com.msecommerce.catalog.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msecommerce.catalog.dtos.InventoryDto;
import com.msecommerce.catalog.dtos.ProductDto;
import com.msecommerce.catalog.services.impl.CatalogServiceImpl;

@Component
public class ProductListener {
    
    @Autowired
    public CatalogServiceImpl catalogService;

    @RabbitListener(queues="update-product-queue")
    public void listenerProduct(ProductDto productDto){
        catalogService.insertProduct(productDto);
    }
    @RabbitListener(queues="update-inventory-queue")
    public void listenerInventory(InventoryDto inventoryDto){
        catalogService.updateInventory(inventoryDto);

    }
}
