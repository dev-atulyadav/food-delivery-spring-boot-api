package com.dev.food_delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.food_delivery.dto.UserEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.UserService;
/**
 * @author Atul
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String home() {
		return "Hello World! This is a testing Route";
	}

	@GetMapping("/get-users")
	public ResponseStruture<List<UserEntity>> getUsers() {
		return userService.findAllService();
	}

	@GetMapping("/findById")
	public ResponseStruture<UserEntity> getUserById(Long id) {
		return userService.findByIdService(id);
	}

	@PostMapping("/save")
	public ResponseStruture<UserEntity> saveUser(@RequestBody UserEntity user) {
		return userService.saveService(user);
	}

	@DeleteMapping("/deleteById")
	public ResponseStruture<Boolean> deleteUserById(Long id) {
		return userService.deleteByIdService(id);
	}

}
