package com.product.website.product.comtroller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.website.product.entities.User;
import com.product.website.product.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		try {
			userService.saveUser(user);
			return ResponseEntity.ok("The User aded successefuly");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("failled to create a User." + e.getMessage());
		}
	}
	
	@PostMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, 
			@RequestBody User updateUser) {
		try {
			User exestingUser = userService.getUserById(id);
			if(exestingUser == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("User not found");
			}
			exestingUser.setFirstname(updateUser.getFirstname());
			exestingUser.setLastname(updateUser.getLastname());
			exestingUser.setEmail(updateUser.getEmail());
			exestingUser.setAddress(updateUser.getAddress());
			exestingUser.setTelNumber(updateUser.getTelNumber());
			exestingUser.setBirthDate(updateUser.getBirthDate());
			
			userService.updateUser(exestingUser);
			return ResponseEntity.ok("User updated sucessfuly");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error: Failed to update product:"  + e.getMessage());
		}
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(User user) {
		try {
			userService.deleteUser(user);
			return ResponseEntity.ok("User deleted succesfuly");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error: Failed to delete users:" + e.getMessage());
		}
	}
		
	@GetMapping("/delete/{id}")
	@DeleteMapping
	public String deleteUserById(@RequestParam Long id) {
		try {
			userService.deleteUserById(id);
			return "User deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: failed to delete user " + e.getMessage();
		}
	}
	
	@GetMapping("/GetUser/{id}")
	public User getProductById(@PathVariable Long id) {
		try {
			User user = userService.getUserById(id);
			if (user == null) {
				throw new UserNotFoundException("User not found with ID: " + id);
			}
			return user;
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
        }
    }
	
	@GetMapping("/listAllUser")
	public List<User> listAllUser() {
		try {
			List<User> users = userService.getAllUser();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
