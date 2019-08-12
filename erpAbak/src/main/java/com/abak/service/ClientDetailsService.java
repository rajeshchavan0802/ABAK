package com.abak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abak.dao.ClientDetailsDao;
import com.abak.entity.ClientDetailsEntity;

@Service
public class ClientDetailsService {
	
	@Autowired
	private ClientDetailsDao clientDetailsDao;
	
	public void svClientDetails(ClientDetailsEntity clientDetailsEntity){
		clientDetailsDao.saveClientDetails(clientDetailsEntity);
	}
	
	@Transactional
	public List<ClientDetailsEntity> getAllClientDetailsEntity(){
		return clientDetailsDao.getAllClientDetailsEntity();
	}
}
