package com.abak.dto;

public class QuotationGrid {
	
	private Integer projectId;
	private String projectName;
	private String customerName;
	private Integer enquiryNumber;
	private Boolean isQuotationPresent;
	private String kindAttPersonEmail;
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getEnquiryNumber() {
		return enquiryNumber;
	}
	public void setEnquiryNumber(Integer enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}
	 
	
	public Boolean getIsQuotationPresent() {
		return isQuotationPresent;
	}
	public void setIsQuotationPresent(Boolean isQuotationPresent) {
		this.isQuotationPresent = isQuotationPresent;
	}
	public String getKindAttPersonEmail() {
		return kindAttPersonEmail;
	}
	public void setKindAttPersonEmail(String kindAttPersonEmail) {
		this.kindAttPersonEmail = kindAttPersonEmail;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
