package com.dev.food_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.food_delivery.dto.AdminEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.AdminService;

/**
 * @author Atul
 */
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/save")
	public ResponseStruture<AdminEntity> saveAdmin(@RequestBody AdminEntity admin) {
		return adminService.saveAdminService(admin);
	}

	@GetMapping("/get/{id}")
	public ResponseStruture<AdminEntity> getAdminById(@PathVariable Long id) {
		return adminService.getAdminByIdService(id);
	}

	@PutMapping("/update/{id}")
	public ResponseStruture<AdminEntity> updateAdmin(@RequestBody AdminEntity admin, @PathVariable Long id) {
		return adminService.updateAdminService(admin, id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseStruture<Boolean> deleteAdmin(@PathVariable Long id) {
		return adminService.deleteAdminByIdService(id);
	}

}
