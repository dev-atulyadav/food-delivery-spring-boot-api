package com.dev.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.food_delivery.dto.RestaurantEntity;

/**
 * @author Atul
 */
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}
