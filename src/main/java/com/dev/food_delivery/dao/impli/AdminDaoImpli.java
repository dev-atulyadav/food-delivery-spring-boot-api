package com.dev.food_delivery.dao.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.food_delivery.dao.AdminDao;
import com.dev.food_delivery.dto.AdminEntity;
import com.dev.food_delivery.repository.AdminRepository;

/**
 * @author Atul
 */

@Repository
public class AdminDaoImpli implements AdminDao {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminEntity saveAdmin(AdminEntity admin) {
		return adminRepository.save(admin);
	}

	@Override
	public AdminEntity getAdminById(Long id) {
		return adminRepository.findById(id).orElse(null);
	}

	@Override
	public AdminEntity updateAdmin(AdminEntity admin, Long id) {
		AdminEntity existingAdmin = getAdminById(id);
		if (existingAdmin != null) {
			existingAdmin.setName(admin.getName());
			existingAdmin.setEmail(admin.getEmail());
			existingAdmin.setPassword(admin.getPassword());
			return adminRepository.save(existingAdmin);
		}
		return null;
	}

	@Override
	public boolean deleteAdminById(Long id) {
		AdminEntity existingAdmin = getAdminById(id);
		if (existingAdmin != null) {
			adminRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
