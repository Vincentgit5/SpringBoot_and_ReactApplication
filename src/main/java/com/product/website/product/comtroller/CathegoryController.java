package com.product.website.product.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.website.product.entities.Category;
import com.product.website.product.service.CategoryService;

@RestController
@RequestMapping("/Category")
public class CathegoryController {

	@Autowired
	CategoryService categoryService;

	// add new category

	@PostMapping("/AddCategory")
	public ResponseEntity<String> saveUser(@RequestBody Category category) {
		try {
			categoryService.saveCategory(category);
			return ResponseEntity.ok("Categoty saved succesfuly");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error: Failed to add category:" + e.getMessage());
		}
	}

	// Update category
	@PutMapping("/UpdateCategory")
	public ResponseEntity<String> updateCategory(@RequestParam Long id, @RequestBody Category updateCategory) {
		try {
			Category existingcategory = categoryService.getCategoryById(id);
			if (existingcategory == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sory User not found");
			}

			existingcategory.setName(updateCategory.getName());
			existingcategory.setReference(updateCategory.getReference());

			categoryService.updateCategory(existingcategory);
			return ResponseEntity.ok("Category updated successfuly");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failled to add Category:" + e.getMessage());
		}
	}

	// Delete category
	@DeleteMapping("/DeleteCategory")
	public ResponseEntity<String> deleteCategory(Category category) {
		try {
			categoryService.deleteCategory(category);
			return ResponseEntity.ok("cattegory deleted successfuly");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failled to delete Category:" + e.getMessage());
		}
	}
	
	@GetMapping("/DeleteOne Category/{id}")
	public ResponseEntity<String> deleteCategorytById(@RequestParam Long id) {
		try {
			categoryService.deleteCategorytById(id);
			return ResponseEntity.ok("Category deleted successfuly");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error: failled to delete category" + e.getMessage());
		}
	}
	
	
	@GetMapping("/GetOneCategory/{id}")
	public ResponseEntity<Category> getCategoryById(@RequestParam Long id){
		try {
			Category category = categoryService.getCategoryById(id);
			if(category == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(category);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/ListAllCategory")
	public ResponseEntity<List<Category>> listAllCategory(){
		try {
			List<Category> category = categoryService.getAllCategory();
			return ResponseEntity.ok(category);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} 
	}
}
 