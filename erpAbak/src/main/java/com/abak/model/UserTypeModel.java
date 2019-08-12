package com.abak.model;

public class UserTypeModel {
	
	private int id;
	private String name;
	private int isActive;
	private int isremoved;
	private int cretaedby;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getIsremoved() {
		return isremoved;
	}
	public void setIsremoved(int isremoved) {
		this.isremoved = isremoved;
	}
	public int getCretaedby() {
		return cretaedby;
	}
	public void setCretaedby(int cretaedby) {
		this.cretaedby = cretaedby;
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
