package com.msecommerce.inventory.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msecommerce.inventory.models.ProductInventory;

@Repository
public interface InventoryRepository extends JpaRepository<ProductInventory, UUID> {
    
}
