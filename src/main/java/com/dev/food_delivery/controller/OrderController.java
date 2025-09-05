package com.dev.food_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.food_delivery.dto.OrderEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.OrderService;

/**
 * @author Atul
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/test")
	public String home() {
		return "Hello World! This is a testing Route";
	}

	@PostMapping("/placeOrder")
	public ResponseStruture<OrderEntity> placeOrder(@RequestBody OrderEntity order) {
		return orderService.placeOrderService(order);
	}

	@GetMapping("/getOrderById/{orderId}")
	public ResponseStruture<OrderEntity> getOrderById(@PathVariable Long orderId) {
		return orderService.getOrderByIdService(orderId);
	}

	@PatchMapping("/cancelOrder/{orderId}")
	public ResponseStruture<Boolean> cancelOrder(@PathVariable Long orderId) {
		return orderService.cancelOrderService(orderId);
	}

	@PatchMapping("/updateOrderStatus/{orderId}/{status}")
	public ResponseStruture<OrderEntity> updateOrderStatus(@PathVariable Long orderId, @PathVariable String status) {
		return orderService.updateOrderStatusService(orderId, status);
	}
}
