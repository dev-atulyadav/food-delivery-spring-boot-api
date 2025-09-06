package com.dev.food_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.food_delivery.dto.RestaurantEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.RestaurantService;

/**
 * @author Atul
 */
@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/save")
	public ResponseStruture<RestaurantEntity> saveRestaurant(@RequestBody RestaurantEntity restaurant) {
		return restaurantService.saveRestaurantService(restaurant);
	}
	
	@PutMapping("/update/{id}")
		public ResponseStruture<RestaurantEntity> updateRestaurant(@RequestBody RestaurantEntity restaurant, @PathVariable Long id) {
		return restaurantService.updateRestaurantService(restaurant, id);
			
	}
	
	@GetMapping("/get/{id}")
	public ResponseStruture<RestaurantEntity> getRestaurantById(@PathVariable Long id) {
		return restaurantService.getRestaurantByIdService(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseStruture<Boolean> deleteRestaurantById(@PathVariable Long id) {
		return restaurantService.deleteRestaurantByIdService(id);
	}

}
