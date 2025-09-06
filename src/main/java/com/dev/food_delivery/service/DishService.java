package com.dev.food_delivery.service;

import com.dev.food_delivery.dto.DishEntity;
import com.dev.food_delivery.response.ResponseStruture;

/**
 * @author Atul
 */
public interface DishService {

	public ResponseStruture<DishEntity> saveDishService(DishEntity dish);

	public ResponseStruture<DishEntity> getDishByIdService(Long id);

	public ResponseStruture<DishEntity> updateDishService(DishEntity dish, Long id);

	public ResponseStruture<Boolean> deleteDishByIdService(Long id);

}
