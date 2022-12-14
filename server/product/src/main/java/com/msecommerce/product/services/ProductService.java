package com.msecommerce.product.services;

import java.util.UUID;

import com.msecommerce.product.dtos.ProductDto;
import com.msecommerce.product.models.Product;

public interface ProductService {
    Product saveProduct(ProductDto productDto);
    void deleteProduct(UUID id);
}