package com.msecommerce.catalog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msecommerce.catalog.dtos.InventoryDto;
import com.msecommerce.catalog.dtos.ProductDto;
import com.msecommerce.catalog.models.ProductCatalog;

@Service
public interface CatalogService {
    void insertProduct(ProductDto ProductDto);
    void updateInventory(InventoryDto inventoryDto);
    List<ProductCatalog> getAllProducts ();
}
