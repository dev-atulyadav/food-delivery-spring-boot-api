package com.dev.food_delivery.service.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dev.food_delivery.dao.OrderDao;
import com.dev.food_delivery.dto.OrderEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.OrderService;

/**
 * @author Atul
 */
@Service
public class OrderServiceImpli implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ResponseStruture<OrderEntity> orderResponseStruture;

	@Autowired
	private ResponseStruture<Boolean> booleanResponseStruture;

	@Override
	public ResponseStruture<OrderEntity> placeOrderService(OrderEntity order) {
		OrderEntity savedOrder = orderDao.placeOrder(order);
		orderResponseStruture.setData(savedOrder);
		orderResponseStruture.setStatus(HttpStatus.CREATED.value());
		orderResponseStruture.setMessage("Order Placed Successfully");
		return orderResponseStruture;
	}

	@Override
	public ResponseStruture<OrderEntity> getOrderByIdService(Long orderId) {
		OrderEntity order = orderDao.getOrderById(orderId);
		if (order != null) {
			orderResponseStruture.setStatus(HttpStatus.OK.value());
			orderResponseStruture.setMessage("Order Found");
			orderResponseStruture.setData(order);
		} else {
			orderResponseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			orderResponseStruture.setMessage("Order Not Found");
			orderResponseStruture.setData(null);
		}
		return orderResponseStruture;
	}

	@Override
	public ResponseStruture<Boolean> cancelOrderService(Long orderId) {
		boolean isCancelled = orderDao.cancelOrder(orderId);
		if (isCancelled) {
			booleanResponseStruture.setStatus(HttpStatus.OK.value());
			booleanResponseStruture.setMessage("Order Cancelled Successfully");
			booleanResponseStruture.setData(true);
		} else {
			booleanResponseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			booleanResponseStruture.setMessage("Order Not Found");
			booleanResponseStruture.setData(false);
		}
		return booleanResponseStruture;
	}

	@Override
	public ResponseStruture<OrderEntity> updateOrderStatusService(Long orderId, String status) {
		OrderEntity updatedOrder = orderDao.updateOrderStatus(orderId, status);
		if (updatedOrder != null) {
			orderResponseStruture.setStatus(HttpStatus.OK.value());
			orderResponseStruture.setMessage("Order Status Updated Successfully");
			orderResponseStruture.setData(updatedOrder);
		} else {
			orderResponseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			orderResponseStruture.setMessage("Order Not Found");
			orderResponseStruture.setData(null);
		}
		return orderResponseStruture;
	}

}
