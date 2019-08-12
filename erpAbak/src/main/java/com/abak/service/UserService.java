package com.abak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abak.dao.UserDao;
import com.abak.entity.UserEntity;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void saveNewUserdetails(UserEntity userEntity){
		userDao.saveUserDetails(userEntity);
	}
	 
	@Transactional
	public List<UserEntity> getAllUsers() {
		return userDao.getAllUsers();
		
	}
}
