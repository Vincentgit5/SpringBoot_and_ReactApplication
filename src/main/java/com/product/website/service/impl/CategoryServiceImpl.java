package com.product.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.website.product.entities.Category;
import com.product.website.product.repository.CathegoryRepository;
import com.product.website.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CathegoryRepository cathegoryRepository;

	public Category saveCategory(Category category) {
		return cathegoryRepository.save(category);
	}

	public Category updateCategory(Category category) {
		return cathegoryRepository.save(category);
	}

	public void deleteCategory(Category category) {
		cathegoryRepository.delete(category);

	}

	public void deleteCategorytById(Long id) {
		cathegoryRepository.deleteById(id);

	}

	public Category getCategoryById(Long id) {
		return cathegoryRepository.findById(id).get();
	}

	public List<Category> getAllCategory() {
		return cathegoryRepository.findAll();
	}

}
