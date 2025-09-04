package com.dev.food_delivery.service.impli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dev.food_delivery.dao.UserDao;
import com.dev.food_delivery.dto.UserEntity;
import com.dev.food_delivery.response.ResponseStruture;
import com.dev.food_delivery.service.UserService;

@Service
public class UserServiceImpli implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ResponseStruture<List<UserEntity>> listUserResponseStruture;
	@Autowired
	private ResponseStruture<UserEntity> userResponseStruture;
	@Autowired
	private ResponseStruture<Boolean> responseStruture;

	@Override
	public ResponseStruture<List<UserEntity>> findAllService() {
		List<UserEntity> users = userDao.findAllDao();
		listUserResponseStruture.setStatus(HttpStatus.OK.value());
		listUserResponseStruture.setMessage("Success");
		listUserResponseStruture.setData(users);
		return listUserResponseStruture;
	}

	@Override
	public ResponseStruture<UserEntity> findByIdService(Long id) {
		UserEntity user = userDao.findByIdDao(id);
		userResponseStruture.setStatus(HttpStatus.OK.value());
		userResponseStruture.setMessage("Success");
		userResponseStruture.setData(user);
		return userResponseStruture;
	}

	@Override
	public ResponseStruture<UserEntity> saveService(UserEntity user) {
		UserEntity savedUser = userDao.saveDao(user);
		userResponseStruture.setData(savedUser);
		userResponseStruture.setStatus(HttpStatus.CREATED.value());
		userResponseStruture.setMessage("User Created Successfully");
		return userResponseStruture;
	}

	@Override
	public ResponseStruture<Boolean> deleteByIdService(Long id) {
		Boolean isDeleted = userDao.deleteByIdDao(id);
		if (!isDeleted) {
			responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
			responseStruture.setMessage("User Not Found");
			responseStruture.setData(false);
			return responseStruture;
		} else {
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setMessage("User Deleted Successfully");
			responseStruture.setData(true);
		}

		return responseStruture;

	}

}
