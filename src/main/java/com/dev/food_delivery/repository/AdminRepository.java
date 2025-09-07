package com.dev.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.food_delivery.dto.AdminEntity;

/**
 * @author Atul
 */
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

}
