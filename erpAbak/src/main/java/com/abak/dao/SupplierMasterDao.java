package com.abak.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abak.entity.SupplierDetails;
import com.abak.entity.SupplierMaster;
import com.abak.entity.UserEntity;

@Component
public class SupplierMasterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void saveSupplierMasterdata(SupplierMaster supplierMasterEntity){
		Session session = sessionFactory.openSession();
		Transaction tx =session.getTransaction();
		tx.begin();
		session.saveOrUpdate(supplierMasterEntity);
		tx.commit();
		session.close();
	}
	
	public List<SupplierMaster> getAllSupplierlist(){
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SupplierMaster.class);
		//criteria.add(Restrictions.eq("isActive",1));
		//criteria.add(Restrictions.eq("isRemoved", 0));
		List<SupplierMaster> supplierMasterEntity = criteria.list();
		return supplierMasterEntity;
	}
}
