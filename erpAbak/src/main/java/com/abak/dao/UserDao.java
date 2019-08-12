package com.abak.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import com.abak.entity.UserEntity;


 
@Repository 
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public UserEntity loginCheck(String username,String password){
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("isActive",1));
		criteria.add(Restrictions.eq("isRemoved", 0));
		UserEntity userEntity = (UserEntity)criteria.uniqueResult();
		return userEntity;
	}
	
	public void saveUserDetails(UserEntity userEntity){
		Session session= sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(userEntity);
		System.out.println(sessionFactory);
		tx.commit();
		session.close();
	}
	
	public List<UserEntity> getAllUsers(){
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("isActive",1));
		criteria.add(Restrictions.eq("isRemoved", 0));
		List<UserEntity> userEntity = criteria.list();
		return userEntity;
	}
	
	/*public List<UserEntity> getAllUsersbyRole(String rolename){
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("isActive",1));
		criteria.add(Restrictions.eq("isRemoved", 0));
		//criteria.setFetchMode("", FetchMode.JOIN).add(Restrictions.eq(propertyName, value));
		
		List<UserEntity> userEntity = criteria.list();
		return userEntity;
	}*/
	
	
	
}
