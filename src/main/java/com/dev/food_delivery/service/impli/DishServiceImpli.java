package com.dev.food_delivery.service.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dev.food_delivery.dto.DishEntity;
import com.dev.food_delivery.repository.DishRepository;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.DishService;

/**
 * @author Atul
 */
@Service
public class DishServiceImpli implements DishService {

	@Autowired
	private DishRepository dishRepository;

	@Autowired
	private ResponseStruture<DishEntity> responseStruture;
	
	@Autowired
	private ResponseStruture<Boolean> booleanResponseStruture;

	@Override
	public ResponseStruture<DishEntity> saveDishService(DishEntity dish) {
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setMessage("Dish Created Successfully");
		responseStruture.setData(dishRepository.save(dish));
		return responseStruture;
	}

	@Override
	public ResponseStruture<DishEntity> getDishByIdService(Long id) {
		DishEntity dish = dishRepository.findById(id).orElse(null);
		if (dish != null) {
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setMessage("Dish Found");
			responseStruture.setData(dish);
		} else {
			responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			responseStruture.setMessage("Dish Not Found");
			responseStruture.setData(null);
		}
		return responseStruture;

	}

	@Override
	public ResponseStruture<DishEntity> updateDishService(DishEntity dish, Long id) {
		DishEntity existingDish = dishRepository.findById(id).orElse(null);
		if (existingDish != null) {
			existingDish.setName(dish.getName());
			existingDish.setDescription(dish.getDescription());
			existingDish.setPrice(dish.getPrice());
			existingDish.setRestaurant(dish.getRestaurant());
			DishEntity updatedDish = dishRepository.save(existingDish);
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setMessage("Dish Updated Successfully");
			responseStruture.setData(updatedDish);
		} else {
			responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			responseStruture.setMessage("Dish Not Found");
			responseStruture.setData(null);
		}
		return responseStruture;
	}

	@Override
	public ResponseStruture<Boolean> deleteDishByIdService(Long id) {
		if (dishRepository.existsById(id)) {
			dishRepository.deleteById(id);
			booleanResponseStruture.setStatus(HttpStatus.OK.value());
			booleanResponseStruture.setMessage("Dish Deleted Successfully");
			booleanResponseStruture.setData(true);
		} else {
			booleanResponseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			booleanResponseStruture.setMessage("Dish Not Found");
			booleanResponseStruture.setData(false);
		}
		return booleanResponseStruture;
	}

}
