package com.abak.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.abak.entity.Project;
@Component
public class SalesValidation {
	
	public List<String> validatedSalesEntry(Project project ) {
		
		List<String> errorList = new ArrayList<String>();
		
		if(project.getProjectName()==null || project.getProjectName()=="") {
			errorList.add("Please enter the Project Name.");
		}
		if(project.getEnquiryNumber()==null) {
			errorList.add("Please enter the enquiry number.");
		}
		/*if(project.getEnquiryRecDate()==null) {
			errorList.add("Please enter the enquiry receive date.");
		}*/
		
		if(project.getCustomerId()==null || project.getCustomerId()==0) {
			errorList.add("Please select customer.");
		}
		if(project.getHandledById()==null || project.getHandledById()==0) {
			errorList.add("Please select handly by.");
		}
		if(project.getEstimatorUserId()==null || project.getEstimatorUserId()==0) {
			errorList.add("Please select estimator.");
		}
		
		
		return errorList;
	}

}
