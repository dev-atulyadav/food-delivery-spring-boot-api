package com.dev.food_delivery.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * @author Atul
 */
 @Entity
 @Data
public class DishEntity {

	 @Id
	private Long id;
	private String name;
	private String description;
	private double price;
	private String imageUrl;
	
	@ManyToOne
	private RestaurantEntity restaurant;
}
