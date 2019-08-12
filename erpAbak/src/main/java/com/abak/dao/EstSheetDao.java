package com.abak.dao;

import java.util.List;

import com.abak.constant.SQLCONSTANT;
import com.abak.entity.Panel;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abak.entity.Project;

@Repository
public class EstSheetDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveEstimation(Project project) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(project);
	}
	
	public List<Object[]> getProjectsByEnquiryNo(Integer enquiryNumber,String projectName){
		
		String sql = SQLCONSTANT.projectDetailsForCloning;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		query.setString("projectName", projectName);
		query.setInteger("enquiryNumber", enquiryNumber);
		
		return query.list();
		
		
		
		/*
		 * Session session = sessionFactory.getCurrentSession(); Criteria criteria =
		 * session.createCriteria(Project.class,"project");
		 * criteria.add(Restrictions.eq("enquiryNumber", enquiryNumber));
		 * criteria.add(Restrictions.eq("projectName", projectName));
		 * criteria.setFetchMode("project.clientDetailsEntity", FetchMode.JOIN);
		 * criteria.createAlias("project.clientDetailsEntity", "clientDetailsEntity");
		 * 
		 * 
		 * //Projection => projectId projectName isEstimationCreated uniqueIdentity
		 * enquiryNumber Projection projection1 = Projections.property("projectId");
		 * Projection projection2 = Projections.property("projectName"); Projection
		 * projection3 = Projections.property("isEstimationCreated"); Projection
		 * projection4 = Projections.property("uniqueIdentity"); Projection projection5=
		 * Projections.property("enquiryNumber"); Projection projection6 =
		 * Projections.property("clientDetailsEntity.clientName");
		 * 
		 * ProjectionList pList = Projections.projectionList();
		 * 
		 * pList.add(projection1); pList.add(projection2); pList.add(projection3);
		 * pList.add(projection4); pList.add(projection5); pList.add(projection6);
		 * criteria.setProjection(pList); List<Object[]> list = criteria.list();
		 * 
		 * 
		 * return list;
		 */
		
	}


	public void disconectPanel(Panel panel){
		Session session = sessionFactory.getCurrentSession();
		session.evict(panel);
	}

}
