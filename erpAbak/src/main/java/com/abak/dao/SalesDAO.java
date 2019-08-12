package com.abak.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abak.entity.Panel;
import com.abak.entity.Project;
import com.abak.utility.GeneralUtility;

@Repository
public class SalesDAO implements ISalesDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void saveProject(Project project) {
		
		Session session= sessionFactory.getCurrentSession();
		String temp = project.getProjectName()+"_"+GeneralUtility.getTime(new Date())+"_"+project.getEnquiryNumber();
		project.setUniqueIdentity(temp);
		session.saveOrUpdate(project);
	}

	@Override
	public List<Project> getAllProject() {
		 
		Criteria criteria =	sessionFactory.getCurrentSession().createCriteria(Project.class);
		return criteria.list();
	}

	@Override
	public Project getProjectById(Integer projectId) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria =	session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		Project project = (Project)criteria.uniqueResult();
		//Project project1 = (Project)session.get(Project.class,  new Integer(project.getProjectId()));
		//project.setPanels(project.getPanels());
		//session.flush();
		//session.clear();
		return project; 
	}
	
	
}
