package com.msecommerce.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msecommerce.catalog.models.ProductCatalog;
import com.msecommerce.catalog.services.impl.CatalogServiceImpl;

@RestController
public class Controller {
    
    @Autowired
    CatalogServiceImpl catalogService;

    @GetMapping("/catalog")
    public ResponseEntity<List<ProductCatalog>> getAllProducts(){
        return ResponseEntity.ok(catalogService.getAllProducts());
    }
}
