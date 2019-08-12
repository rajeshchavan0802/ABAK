package com.abak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abak.dao.UserTypeDao;
import com.abak.entity.UserTypeEntity;

@Service
public class UserTypeService {
	
	@Autowired
	private UserTypeDao userTypeDao;
	
	public void saveUserType(UserTypeEntity userTypeEntity){
		userTypeDao.saveUserTypeDetails(userTypeEntity);
	}
}
