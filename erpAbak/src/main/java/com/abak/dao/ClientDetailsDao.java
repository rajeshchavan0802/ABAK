package com.abak.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.abak.entity.ClientDetailsEntity;


import java.math.BigInteger;

@Repository
public class ClientDetailsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveClientDetails(ClientDetailsEntity clientDetailsEntity){
		Session session= sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		System.out.println(sessionFactory);
		session.save(clientDetailsEntity);
		tx.commit();
		long lastid=((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		System.out.println("================"+lastid+"==========");
		session.close();
	}
	
	public List<ClientDetailsEntity> getAllClientDetailsEntity(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientDetailsEntity.class);
		criteria.addOrder(Order.desc("clientName"));
		return criteria.list();
		}
	
	
}
