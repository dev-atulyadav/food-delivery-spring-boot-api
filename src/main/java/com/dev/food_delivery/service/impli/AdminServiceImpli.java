package com.dev.food_delivery.service.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.food_delivery.dao.AdminDao;
import com.dev.food_delivery.dto.AdminEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.AdminService;

/**
 * @author Atul
 */
@Service
public class AdminServiceImpli implements AdminService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ResponseStruture<AdminEntity> responseStruture;

	@Autowired
	private ResponseStruture<Boolean> stringResponseStruture;

	@Override
	public ResponseStruture<AdminEntity> saveAdminService(AdminEntity admin) {
		AdminEntity savedAdmin = adminDao.saveAdmin(admin);
		if (savedAdmin != null) {
			responseStruture.setStatus(201);
			responseStruture.setMessage("Admin created successfully");
			responseStruture.setData(savedAdmin);
			return responseStruture;
		} else {
			responseStruture.setStatus(500);
			responseStruture.setMessage("Failed to create admin");
			responseStruture.setData(null);
			return responseStruture;
		}
	}

	@Override
	public ResponseStruture<AdminEntity> getAdminByIdService(Long id) {
		AdminEntity admin = adminDao.getAdminById(id);
		if (admin != null) {
			responseStruture.setStatus(200);
			responseStruture.setMessage("Admin found");
			responseStruture.setData(admin);
			return responseStruture;
		} else {
			responseStruture.setStatus(404);
			responseStruture.setMessage("Admin not found");
			responseStruture.setData(null);
			return responseStruture;
		}
	}

	@Override
	public ResponseStruture<AdminEntity> updateAdminService(AdminEntity admin, Long id) {
		AdminEntity updatedAdmin = adminDao.updateAdmin(admin, id);
		if (updatedAdmin != null) {
			responseStruture.setStatus(200);
			responseStruture.setMessage("Admin updated successfully");
			responseStruture.setData(updatedAdmin);
			return responseStruture;
		} else {
			responseStruture.setStatus(404);
			responseStruture.setMessage("Admin not found");
			responseStruture.setData(null);
			return responseStruture;
		}
	}

	@Override
	public ResponseStruture<Boolean> deleteAdminByIdService(Long id) {
		boolean isDeleted = adminDao.deleteAdminById(id);
		if (isDeleted) {
			stringResponseStruture.setStatus(200);
			stringResponseStruture.setMessage("Admin deleted successfully");
			stringResponseStruture.setData(true);
			return stringResponseStruture;
		} else {
			stringResponseStruture.setStatus(404);
			stringResponseStruture.setMessage("Admin not found");
			stringResponseStruture.setData(false);
			return stringResponseStruture;
		}
	}

}
