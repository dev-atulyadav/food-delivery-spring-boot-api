package com.dev.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.food_delivery.dto.DishEntity;

/**
 * @author Atul
 */
public interface DishRepository extends JpaRepository<DishEntity, Long> {

}
