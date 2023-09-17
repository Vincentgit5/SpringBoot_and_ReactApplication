package com.product.website.product.service;

import java.util.List;

import com.product.website.product.entities.Category;

public interface CategoryService {
	
	Category saveCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategory(Category category);
	void deleteCategorytById(Long id);
	Category getCategoryById(Long id);
	List<Category> getAllCategory();

}
