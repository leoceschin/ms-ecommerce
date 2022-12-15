package com.msecommerce.product.controllers;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msecommerce.product.dtos.ProductDto;
import com.msecommerce.product.models.Product;
import com.msecommerce.product.services.impl.ProductServiceImpl;

@RestController
public class ProductController {
    
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/register-product")
    public ResponseEntity<Product> createProduct (@RequestBody @Validated ProductDto productDto){
        Product product = productService.saveProduct(productDto);
        String routingKey = "INSERT-PRODUCT-QUEUE";
        
        rabbitTemplate.convertAndSend(routingKey, productDto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<?> deleteProduct (@PathVariable("id") UUID id){
        try{
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND); 
        }
    }
}
