package com.dev.food_delivery.service;

import com.dev.food_delivery.dto.OrderEntity;
import com.dev.food_delivery.response.ResponseStruture;

/**
 * @author Atul
 */
public interface OrderService {

	public ResponseStruture<OrderEntity> placeOrderService(OrderEntity order);

	public ResponseStruture<OrderEntity> getOrderByIdService(Long orderId);

	public ResponseStruture<Boolean> cancelOrderService(Long orderId);

	public ResponseStruture<OrderEntity> updateOrderStatusService(Long orderId, String status);

}
