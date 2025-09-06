package com.dev.food_delivery.dao.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.food_delivery.dao.DishDao;
import com.dev.food_delivery.dto.DishEntity;
import com.dev.food_delivery.repository.DishRepository;

/**
 * @author Atul
 */
@Repository
public class DishDaoImpli implements DishDao {

	@Autowired
	private DishRepository dishRepository;

	@Override
	public DishEntity saveDish(DishEntity dish) {
		return dishRepository.save(dish);
	}

	@Override
	public DishEntity getDishById(Long id) {
		return dishRepository.findById(id).orElse(null);
	}

	@Override
	public DishEntity updateDish(DishEntity dish, Long id) {
		DishEntity existingDish = dishRepository.findById(id).orElse(null);
		if (existingDish != null) {
			existingDish.setName(dish.getName());
			existingDish.setDescription(dish.getDescription());
			existingDish.setPrice(dish.getPrice());
			existingDish.setRestaurant(dish.getRestaurant());
			return dishRepository.save(existingDish);
		}
		return null;
	}

	@Override
	public boolean deleteDishById(Long id) {
		if (dishRepository.existsById(id)) {
			dishRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
