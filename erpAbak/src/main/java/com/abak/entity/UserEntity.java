package com.abak.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email_id")
	private String emailId;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="p_mobile_number")
	private String priMobileNumber;
	@Column(name="s_mobile_number")
	private String secMobileNumber;
	@Column(name="designation")
	private String designation;
	@Column(name="user_type_id")
	private int userTypeId;
	@Column(name="is_active")
	private int isActive;
	@Column(name="is_removed")
	private int isRemoved;
	@Column(name="created_by")
	private int createdBy;
	@Column(name="created_date")
	private String createdDatetime;
	@Column(name="updated_by")
	private int updatedBy;
	@Column(name="updated_datetime")
	private String updatedDatetime;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	
}
