package com.dev.food_delivery.dao.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.food_delivery.dao.OrderDao;
import com.dev.food_delivery.dto.OrderEntity;
import com.dev.food_delivery.repository.OrderRepository;

/**
 * @author Atul
 */
@Repository
public class OrderDaoImpli implements OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderEntity placeOrder(OrderEntity order) {
		return orderRepository.save(order);
	}

	@Override
	public OrderEntity getOrderById(Long orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public boolean cancelOrder(Long orderId) {
		OrderEntity order = getOrderById(orderId);
		if (order != null) {
			updateOrderStatus(orderId, "Cancelled");
			return true;
		}
		return false;
	}

	@Override
	public OrderEntity updateOrderStatus(Long orderId, String status) {
		OrderEntity order = getOrderById(orderId);
		if (order != null) {
			order.setStatus(status);
			return orderRepository.save(order);
		}
		return null;
	}

}
