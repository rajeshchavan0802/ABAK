package com.abak.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client_master")
public class ClientDetailsEntity {
	
	@Id
	@Column(name="c_id")
	private int id;
	@Column(name="c_name")
	private String clientName;
	@Column(name="c_address")
	private String clientAddress;
	@Column(name="c_landline")
	private String clientLandline;
	@Column(name="c_phoneno")
	private String clientPhoneNo;
	@Column(name="c_note")
	private String clientNote;
	@Column(name="c_created_by")
	private String clientCreatedBy;
	@Column(name="c_created_datetime")
	private String clientCreatedDatetime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientLandline() {
		return clientLandline;
	}
	public void setClientLandline(String clientLandline) {
		this.clientLandline = clientLandline;
	}
	public String getClientPhoneNo() {
		return clientPhoneNo;
	}
	public void setClientPhoneNo(String clientPhoneNo) {
		this.clientPhoneNo = clientPhoneNo;
	}
	public String getClientNote() {
		return clientNote;
	}
	public void setClientNote(String clientNote) {
		this.clientNote = clientNote;
	}
	public String getClientCreatedBy() {
		return clientCreatedBy;
	}
	public void setClientCreatedBy(String clientCreatedBy) {
		this.clientCreatedBy = clientCreatedBy;
	}
	public String getClientCreatedDatetime() {
		return clientCreatedDatetime;
	}
	public void setClientCreatedDatetime(String clientCreatedDatetime) {
		this.clientCreatedDatetime = clientCreatedDatetime;
	}
}
