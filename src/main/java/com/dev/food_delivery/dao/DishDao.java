package com.dev.food_delivery.dao;

import com.dev.food_delivery.dto.DishEntity;

/**
 * @author Atul
 */
public interface DishDao {
	
	public DishEntity saveDish(DishEntity dish);
	
	public DishEntity getDishById(Long id);
	
	public DishEntity updateDish(DishEntity dish, Long id);
	
	public boolean deleteDishById(Long id);

}
