package com.dev.food_delivery.dao.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.food_delivery.dto.RestaurantEntity;
import com.dev.food_delivery.repository.RestaurantRepository;

/**
 * @author Atul
 */
@Repository
public class RestaurantDaoImpli implements com.dev.food_delivery.dao.RestaurantDao {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public RestaurantEntity saveRestaurant(com.dev.food_delivery.dto.RestaurantEntity restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public RestaurantEntity getRestaurantById(Long id) {
		return restaurantRepository.findById(id).orElse(null);
	}

	@Override
	public RestaurantEntity updateRestaurant(com.dev.food_delivery.dto.RestaurantEntity restaurant, Long id) {
		RestaurantEntity existingRestaurant = restaurantRepository.findById(id).orElse(null);
		if (existingRestaurant != null) {
			existingRestaurant.setOwnerName(restaurant.getOwnerName());
			existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
			existingRestaurant.setAddress(restaurant.getAddress());
			existingRestaurant.setPhone(restaurant.getPhone());
			existingRestaurant.setEmail(restaurant.getEmail());
			return restaurantRepository.save(existingRestaurant);
		}
		return null;
	}

	@Override
	public boolean deleteRestaurantById(Long id) {
		if (restaurantRepository.existsById(id)) {
			restaurantRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
