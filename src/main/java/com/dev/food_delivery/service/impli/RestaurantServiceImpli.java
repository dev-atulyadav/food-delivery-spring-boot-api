package com.dev.food_delivery.service.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dev.food_delivery.dao.RestaurantDao;
import com.dev.food_delivery.dto.RestaurantEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.RestaurantService;

/**
 * @author Atul
 */
@Service
public class RestaurantServiceImpli implements RestaurantService {
	
	@Autowired
	private RestaurantDao restaurantDao;
	@Autowired
	private ResponseStruture<RestaurantEntity> responseStruture;
	
	@Autowired
	private ResponseStruture<Boolean> booleanResponseStruture;	
	
	@Override
	public ResponseStruture<RestaurantEntity> saveRestaurantService(RestaurantEntity restaurant) {
		RestaurantEntity savedRestaurant = restaurantDao.saveRestaurant(restaurant);
		responseStruture.setData(savedRestaurant);
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setMessage("Restaurant Created Successfully");
		return responseStruture;
	}
	@Override
	public ResponseStruture<RestaurantEntity> getRestaurantByIdService(Long id) {
		RestaurantEntity restaurant = restaurantDao.getRestaurantById(id);
		if (restaurant != null) {
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setMessage("Restaurant Found");
			responseStruture.setData(restaurant);
		} else {
			responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			responseStruture.setMessage("Restaurant Not Found");
			responseStruture.setData(null);
		}
		return responseStruture;
	}
	@Override
	public ResponseStruture<RestaurantEntity> updateRestaurantService(RestaurantEntity restaurant, Long id) {
		RestaurantEntity updatedRestaurant = restaurantDao.updateRestaurant(restaurant, id);
		if (updatedRestaurant != null) {
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setMessage("Restaurant Updated Successfully");
			responseStruture.setData(updatedRestaurant);
		} else {
			responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			responseStruture.setMessage("Restaurant Not Found");
			responseStruture.setData(null);
		}
		return responseStruture;
	}
	@Override
	public ResponseStruture<Boolean> deleteRestaurantByIdService(Long id) {
		boolean isDeleted = restaurantDao.deleteRestaurantById(id);
		if (isDeleted) {
			booleanResponseStruture.setStatus(HttpStatus.OK.value());
			booleanResponseStruture.setMessage("Restaurant Deleted Successfully");
			booleanResponseStruture.setData(true);
		} else {
			booleanResponseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			booleanResponseStruture.setMessage("Restaurant Not Found");
			booleanResponseStruture.setData(false);
		}
		return booleanResponseStruture;	
	}

}
