package com.msecommerce.product.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msecommerce.product.dtos.ProductDto;
import com.msecommerce.product.models.Product;
import com.msecommerce.product.repositories.ProductRepository;
import com.msecommerce.product.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isEmpty()){
            Product product = optionalProduct.get();
            productRepository.delete(product);
        }else{
            throw new RuntimeException("Produto inexistente");
        }
        
    }
    
}
