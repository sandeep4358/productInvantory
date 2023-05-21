package com.javafruit.ProductInventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafruit.ProductInventory.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	//Optional<List<Product>> get();
	
}
