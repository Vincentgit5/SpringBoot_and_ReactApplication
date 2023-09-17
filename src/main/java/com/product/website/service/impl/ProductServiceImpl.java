package com.product.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.website.product.entities.Product;
import com.product.website.product.repository.ProductRepository;
import com.product.website.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
		
	}

	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
		
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	
	

}
