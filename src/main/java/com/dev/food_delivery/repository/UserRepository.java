package com.dev.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.food_delivery.dto.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	

	UserEntity findByEmail(String email);
}
