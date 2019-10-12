package com.abak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abak.dao.SupplierMasterDao;
import com.abak.entity.SupplierDetails;
import com.abak.entity.SupplierMaster;

@Service
public class SupplierMasterService {
	
	@Autowired
	private SupplierMasterDao supplierMasterDao;
	
	@Transactional
	public void saveSupplierMaster(SupplierMaster supplierMasterEntity ){
		for(SupplierDetails temp : supplierMasterEntity.getSupplierDetailses()){
			temp.setSupplierMaster(supplierMasterEntity);
		}
		supplierMasterDao.saveSupplierMasterdata(supplierMasterEntity);
		
	}
	
	@Transactional
	public List<SupplierMaster> getAllSupplier() {
		return supplierMasterDao.getAllSupplierlist();
		
	}
	
	@Transactional
	public SupplierMaster getSupplierDataInfo(Integer supplierNumber) {
		return supplierMasterDao.getAllSupplierData(supplierNumber);
		
	}
	
	@Transactional
	public int deleteSupllierDataDetails(Integer supplierNumber){
		return supplierMasterDao.deleteSupllierData(supplierNumber);
		
	}
}
