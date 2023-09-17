package com.product.website.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.website.product.entities.Category;

public interface CathegoryRepository extends JpaRepository<Category, Long> {

}
