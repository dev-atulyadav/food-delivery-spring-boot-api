package com.dev.food_delivery.service;

import java.util.List;

import com.dev.food_delivery.dto.UserEntity;
import com.dev.food_delivery.response.ResponseStruture;
/**
 * @author Atul
 */
public interface UserService {

	ResponseStruture<List<UserEntity>> findAllService();

	ResponseStruture<UserEntity> findByIdService(Long id);

	ResponseStruture<UserEntity> saveService(UserEntity user);

	ResponseStruture<Boolean> deleteByIdService(Long id);

}
