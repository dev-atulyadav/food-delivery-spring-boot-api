package com.dev.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.dev.food_delivery.dto.OrderEntity;

/**
 * @author Atul
 */
@Component
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
