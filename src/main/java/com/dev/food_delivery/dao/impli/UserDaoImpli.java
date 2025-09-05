package com.dev.food_delivery.dao.impli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.food_delivery.dao.UserDao;
import com.dev.food_delivery.dto.UserEntity;
import com.dev.food_delivery.repository.UserRepository;
/**
 * @author Atul
 */
@Repository
class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity findByIdDao(Long id) {

		return userRepository.findById(id).get();
	}

	@Override
	public List<UserEntity> findAllDao() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity saveDao(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public boolean deleteByIdDao(Long id) {
		if (!userRepository.existsById(id)) {
			return false;
		} else {
			userRepository.deleteById(id);
			return true;
		}

	}

}
