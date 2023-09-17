package com.product.website.product.service;

import java.util.List;

import com.product.website.product.entities.User;

public interface UserService {
	User saveUser(User user);
	User updateUser(User user);
	void deleteUser(User user);
	void deleteUserById(Long id);
	User getUserById(Long id);
	List<User> getAllUser();

}
