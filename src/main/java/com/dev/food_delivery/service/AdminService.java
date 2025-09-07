package com.dev.food_delivery.service;

/**
 * @author Atul
 */

import com.dev.food_delivery.dto.AdminEntity;
import com.dev.food_delivery.response.ResponseStruture;

public interface AdminService {

	public ResponseStruture<AdminEntity> saveAdminService(AdminEntity admin);

	public ResponseStruture<AdminEntity> getAdminByIdService(Long id);

	public ResponseStruture<AdminEntity> updateAdminService(AdminEntity admin, Long id);

	public ResponseStruture<Boolean> deleteAdminByIdService(Long id);

}
