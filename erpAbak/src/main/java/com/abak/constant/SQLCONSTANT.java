package com.abak.constant;

public interface SQLCONSTANT {

	public final String projectDetailsForCloning 
								= "select a.projectId, a.projectName, a.isEstimationCreated, a.uniqueIdentity, a.enquiryNumber, b.clientName "
								+ "from Project a, ClientDetailsEntity b "
								+ "where a.projectName=:projectName and a.enquiryNumber=:enquiryNumber and a.customerId=b.id";
	
	
	
}
