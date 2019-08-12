package com.abak.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class UserTypeEntity {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="is_active")
	private int isActive;
	@Column(name="is_removed")
	private int isremoved;
	@Column(name="created_by")
	private int cretaedby;
	@Column(name="created_datetime")
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
	
}
