package com.product.website.product.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.website.product.entities.Product;
import com.product.website.product.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

	@Autowired
	ProductService productService;

	
	//Save Product
	@PostMapping("/AddProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		try {
			productService.saveProduct(product);
			return ResponseEntity.ok("Product added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to add product: " + e.getMessage());
		}
	}

	// update product method
	@PutMapping("/UpdateProduct/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, 
			@RequestBody Product updatedProduct) {
		try {
			Product existingProduct = productService.getProductById(id);
			if (existingProduct == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Product not found");
			}

			// update you product values with the news values ²
			existingProduct.setNameProduct(updatedProduct.getNameProduct());
			existingProduct.setPriceProdduct(updatedProduct.getPriceProdduct());
			existingProduct.setCreationDate(updatedProduct.getCreationDate());
			existingProduct.setExpirationDate(updatedProduct.getExpirationDate());
			existingProduct.setQuantity(updatedProduct.getQuantity());

			// Save updated Product
			productService.updateProduct(existingProduct);
			return ResponseEntity.ok("Product updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to update product: " + e.getMessage());
		}
	}

	// DELETE all the products
	@DeleteMapping("/DeleteAllProducts")
	public ResponseEntity<String> deleteAllProducts(Product product) {
		try {
			productService.deleteProduct(product);
			return ResponseEntity.ok("All products has deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(" Error: Failed to delete all products: " + e.getMessage());
		}
	}

	//DeleteProduct by id
	@DeleteMapping("/DeleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		try {
			productService.deleteProductById(id);
			return ResponseEntity.ok("Product deleted has successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error: Failed to delete product: " + e.getMessage());
		}
	}
	
	//get one product
	@GetMapping("/GetProduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	    try {
	        Product product = productService.getProductById(id);
	        if (product == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	        return ResponseEntity.ok(product);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}

	//List all products
	@GetMapping("/ListAllProducts")
	public ResponseEntity<List<Product>> listAllProducts() {
		try {
			List<Product> products = productService.getAllProduct();
			return ResponseEntity.ok(products);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}