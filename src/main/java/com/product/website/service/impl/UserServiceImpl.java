package com.product.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.website.product.entities.User;
import com.product.website.product.repository.UserRepository;
import com.product.website.product.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

	public User getUserById(Long id) {
		
		return userRepository.findById(id).get();
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
