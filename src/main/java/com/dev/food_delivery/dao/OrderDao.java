package com.dev.food_delivery.dao;

import com.dev.food_delivery.dto.OrderEntity;

/**
 * @author Atul
 */
public interface OrderDao {

	public OrderEntity placeOrder(OrderEntity order);

	public OrderEntity getOrderById(Long orderId);

	public boolean cancelOrder(Long orderId);

	public OrderEntity updateOrderStatus(Long orderId, String status);

}
