package com.abak.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abak.entity.UserTypeEntity;

@Component
public class UserTypeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveUserTypeDetails(UserTypeEntity userTypeEntity){
		Session session=sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(userTypeEntity);
		transaction.commit();
		session.close();
	}
	
	@Transactional(readOnly=true)
	public List<UserTypeEntity> listOfUserType(){
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserTypeEntity.class);
		criteria.add(Restrictions.eq("isActive", 1));
		criteria.add(Restrictions.eq("isremoved", 0));
		List<UserTypeEntity> userTypeEntities = (List<UserTypeEntity>)criteria.list();
		return userTypeEntities;
		
//		StringBuilder hql = new StringBuilder();
//		hql.append("select u from UserTypeEntity u where u.isActive='1' and u.isremoved='0'");
//		Session session = sessionFactory.openSession();
//		Query query = session.createQuery(hql.toString());
//		List<UserTypeEntity> userTypeEntities = query.list();
//		return userTypeEntities;
	}
}
