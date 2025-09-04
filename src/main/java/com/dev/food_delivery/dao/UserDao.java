package com.dev.food_delivery.dao;

import java.util.List;

import com.dev.food_delivery.dto.UserEntity;

public interface UserDao {
	
	UserEntity findByIdDao(Long id);

	List<UserEntity> findAllDao();

	UserEntity saveDao(UserEntity user);

	boolean deleteByIdDao(Long id);
}
