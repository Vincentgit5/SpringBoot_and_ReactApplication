package com.product.website.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.website.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
