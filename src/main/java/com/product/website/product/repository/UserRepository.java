package com.product.website.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.website.product.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
