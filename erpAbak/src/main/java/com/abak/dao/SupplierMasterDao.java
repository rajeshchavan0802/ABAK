package com.abak.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abak.entity.Project;
import com.abak.entity.SupplierDetails;
import com.abak.entity.SupplierMaster;
import com.abak.entity.UserEntity;

@Component
public class SupplierMasterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void saveSupplierMasterdata(SupplierMaster supplierMasterEntity){
		Session session = sessionFactory.getCurrentSession();
		//Transaction tx =session.getTransaction();
		//tx.begin();
		session.saveOrUpdate(supplierMasterEntity);
		//tx.commit();
		//session.close();
	}
	
	public List<SupplierMaster> getAllSupplierlist(){
		//Criteria criteria =	sessionFactory.getCurrentSession().createCriteria(Project.class);
			StringBuilder hql = new StringBuilder();
			hql.append("select u from SupplierMaster u");
			Session session = sessionFactory.openSession();
			Query query=session.createQuery(hql.toString());
			List<SupplierMaster> supplierMaster =query.list();
			return supplierMaster;
		
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SupplierMaster.class);
		//List<SupplierMaster> supplierMasterEntity = criteria.list();
		//return criteria.list();
	}
	
	public SupplierMaster getAllSupplierData(Integer supplierNumber){
		//Criteria criteria =	sessionFactory.getCurrentSession().createCriteria(Project.class);
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria =	session.createCriteria(SupplierMaster.class);
		//criteria.setFetchMo, FetchMode.JOIN);
		criteria.add(Restrictions.eq("supplierNumber", supplierNumber));
		SupplierMaster supplierMaster = (SupplierMaster)criteria.uniqueResult();
		
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SupplierMaster.class);
		//List<SupplierMaster> supplierMasterEntity = criteria.list();
		return supplierMaster;
	}
	
	public int deleteSupllierData(Integer supplierNumber){
		StringBuilder hql = new StringBuilder();
		hql.append("delete from SupplierMaster where supplierNumber= :supplierNumber");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql.toString());
		query.setParameter("supplierNumber", supplierNumber);
		int res = query.executeUpdate();
		return res;
	}
}
