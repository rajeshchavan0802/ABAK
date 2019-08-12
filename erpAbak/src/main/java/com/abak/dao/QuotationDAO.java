package com.abak.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuotationDAO implements IQuotationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Object[]> getListForQuotationGrid(){
		
		String sql = "select p.projectId, p.projectName, p.kindAttPersonEmail, p.enquiryNumber, c.clientName, p.isQuotationPresent from Project p, ClientDetailsEntity c where p.isEstimationCreated=:isEstimationCreated and p.customerId=c.id";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("isEstimationCreated", true);
		List<Object[]> result = query.list();
		return result;
	}
	
	

}
