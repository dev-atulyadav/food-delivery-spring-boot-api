package com.dev.food_delivery.dao;

import com.dev.food_delivery.dto.RestaurantEntity;

/**
 * @author Atul
 */
public interface RestaurantDao {

	public RestaurantEntity saveRestaurant(RestaurantEntity restaurant);

	public RestaurantEntity getRestaurantById(Long id);

	public RestaurantEntity updateRestaurant(RestaurantEntity restaurant, Long id);

	public boolean deleteRestaurantById(Long id);

}
