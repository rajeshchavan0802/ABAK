package com.abak.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abak.dao.ISalesDAO;
import com.abak.entity.Project;
import com.abak.model.ProjectInformation;

@Service
public class SalesService implements ISalesService{

	@Autowired
	private ISalesDAO salesDAO;
	
	@Override
	@Transactional
	public void saveProject(Project project) {
		salesDAO.saveProject(project);
	}

	@Override
	@Transactional
	public List<Project> getAllProject() {
	 
		return salesDAO.getAllProject();
	}

	@Override
	@Transactional(readOnly=true)
	public Project getProjectById(Integer projectId) {
		return salesDAO.getProjectById(projectId);
	}

	@Override
	@Transactional
	public ProjectInformation getProjectInformation(Integer projectId) {
		ProjectInformation projectInformation = new ProjectInformation();
		Project project = this.getProjectById(projectId);
		
		if(project != null) {
			projectInformation.setProjectName(project.getProjectName());
			projectInformation.setEnquiryNumber(project.getEnquiryNumber());
			projectInformation.setRevisionNumber(project.getRevisionNumber());
			projectInformation.setEnquiryRecDate(project.getEnquiryRecDate());
			projectInformation.setQuetationSendDate(project.getQuotationSentDate());
			projectInformation.setTypesofPannel(project.getTypesOfPanel());
			projectInformation.setJobNumber(project.getJobNumber());
			projectInformation.setDrawingAprvDate(project.getDrawingAprvDate());
			projectInformation.setQuntity(project.getNumbersOfPanels());
			projectInformation.setEnquiryType(project.getEnquiryType());
			projectInformation.setEstimator(project.getEstimatorUserName());
			projectInformation.setDraftman(project.getDraftmanName());
			projectInformation.setSchemaDesigner(project.getSchemaDesignerName());
		}
		
		return projectInformation;
	}
	
	
	
	
}
