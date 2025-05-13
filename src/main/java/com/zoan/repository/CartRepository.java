package com.zoan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zoan.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>{
	List<Cart> findByUserEmail(String userEmail);
}
