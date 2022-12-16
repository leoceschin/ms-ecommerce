package com.msecommerce.catalog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msecommerce.catalog.models.ProductCatalog;

@Repository
public interface CatalogRepository extends JpaRepository<ProductCatalog, UUID> {
    
}
