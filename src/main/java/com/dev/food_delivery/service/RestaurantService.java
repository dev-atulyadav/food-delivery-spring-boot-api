package com.dev.food_delivery.service;

import com.dev.food_delivery.dto.RestaurantEntity;
import com.dev.food_delivery.response.ResponseStruture;

/**
 * @author Atul
 */
public interface RestaurantService {

	public ResponseStruture<RestaurantEntity> saveRestaurantService(RestaurantEntity restaurant);

	public ResponseStruture<RestaurantEntity> getRestaurantByIdService(Long id);

	public ResponseStruture<RestaurantEntity> updateRestaurantService(RestaurantEntity restaurant, Long id);

	public ResponseStruture<Boolean> deleteRestaurantByIdService(Long id);

}
