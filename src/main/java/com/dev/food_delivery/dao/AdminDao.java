package com.dev.food_delivery.dao;

import com.dev.food_delivery.dto.AdminEntity;

/**
 * @author Atul
 */
public interface AdminDao {

	public AdminEntity saveAdmin(AdminEntity admin);

	public AdminEntity getAdminById(Long id);

	public AdminEntity updateAdmin(AdminEntity admin, Long id);

	public boolean deleteAdminById(Long id);

}
