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

import com.dev.food_delivery.dto.DishEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.DishService;

/**
 * @author Atul
 */
@RestController
@RequestMapping("/api/v1/dishes")
public class DishController {
	
	@Autowired
	private DishService dishService;
	
	@PostMapping("/save")
	public ResponseStruture<DishEntity> saveDish(@RequestBody DishEntity dish) {
		return dishService.saveDishService(dish);
	}
	
	@GetMapping("/get/{id}")
	public ResponseStruture<DishEntity> getDishById(@PathVariable Long id) {
		return dishService.getDishByIdService(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseStruture<DishEntity> updateDish(@RequestBody DishEntity dish, @PathVariable Long id) {
		return dishService.updateDishService(dish, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseStruture<Boolean> deleteDish(@PathVariable Long id) {
		return dishService.deleteDishByIdService(id);
	}

}
