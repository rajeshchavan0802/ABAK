package com.abak.model;


public class UserModel {
	
	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String username;
	private String password;
	private String priMobileNumber;
	private String secMobileNumber;
	private String designation;
	private int userTypeId;
	private int isActive;
	private int isRemoved;
	private int createdBy;
	private String createdDatetime;
	private int updatedBy;
	private String updatedDatetime;
	private String message;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPriMobileNumber() {
		return priMobileNumber;
	}
	public void setPriMobileNumber(String priMobileNumber) {
		this.priMobileNumber = priMobileNumber;
	}
	public String getSecMobileNumber() {
		return secMobileNumber;
	}
	public void setSecMobileNumber(String secMobileNumber) {
		this.secMobileNumber = secMobileNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getIsRemoved() {
		return isRemoved;
	}
	public void setIsRemoved(int isRemoved) {
		this.isRemoved = isRemoved;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDatetime() {
		return updatedDatetime;
	}
	public void setUpdatedDatetime(String updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
