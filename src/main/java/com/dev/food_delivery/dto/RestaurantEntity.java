package com.dev.food_delivery.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class RestaurantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ownerName;
	private String restaurantName;
	private String address;
	private String phone;
	private String email;
	private String password;
	private String accessToken;
	private String refreshToken;

	@OneToMany
	private List<DishEntity> dishes;

}
