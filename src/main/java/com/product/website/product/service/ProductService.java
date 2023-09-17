package com.product.website.product.service;

import java.util.List;

import com.product.website.product.entities.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct(Product product);
	void deleteProductById(Long id);
	Product getProductById(Long id);
	List<Product> getAllProduct();
	
}
