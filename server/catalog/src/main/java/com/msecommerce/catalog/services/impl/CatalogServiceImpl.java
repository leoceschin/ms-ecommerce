package com.msecommerce.catalog.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msecommerce.catalog.dtos.InventoryDto;
import com.msecommerce.catalog.dtos.ProductDto;
import com.msecommerce.catalog.models.ProductCatalog;
import com.msecommerce.catalog.repositories.CatalogRepository;
import com.msecommerce.catalog.services.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogRepository catalogRepository;

    @Override
    public void insertProduct(ProductDto productDto) {
        Optional<ProductCatalog> optionalProduct = catalogRepository.findById(productDto.getId());
        if(!optionalProduct.isPresent()){
            ProductCatalog productCatalog = new ProductCatalog();
            BeanUtils.copyProperties(productDto, productCatalog);
            catalogRepository.save(productCatalog);
        }else{
            throw new RuntimeException("Esse produto já existe");
        }
    }

    @Override
    public void updateInventory(InventoryDto inventoryDto) {
        Optional<ProductCatalog> optionalCatalog = catalogRepository.findById(inventoryDto.getId());
        if(optionalCatalog.isPresent()){
            ProductCatalog productCatalog = optionalCatalog.get();
            productCatalog.setQuantity(inventoryDto.getQuantity());
        }else{
            throw new RuntimeException("Esse produto não existe!");
        }
    }

    @Override
    public List<ProductCatalog> getAllProducts() {
        return catalogRepository.findAll();
    }
    
}
