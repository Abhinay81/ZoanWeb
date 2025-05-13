package com.zoan.repository;

import org.springframework.data.repository.CrudRepository;

import com.zoan.entity.User;

public interface UserRepository extends CrudRepository<User, String>{

}
