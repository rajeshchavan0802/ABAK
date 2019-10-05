package com.abak.entity;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

/**
 * SupplierMaster generated by hbm2java
 */
@Entity
@Table(name = "supplier_master")
public class SupplierMaster implements java.io.Serializable {

	private int supplierNumber;
	private String supplierName;
	private String kindAttn;
	private Integer contactNumber;
	private Integer mobileNumber;
	private String emailId;
	private String gstNumber;
	private String paymentTerm;
	private String paymentMode;
	private String document;
	private String address;
	private Integer accountNumber;
	private String bankName;
	private String ifscCode;
	private Integer status;
	private List<SupplierDetails> supplierDetailses = new ArrayList<SupplierDetails>(0);

	

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "supplier_number", unique = true, nullable = false)
	public int getSupplierNumber() {
		return this.supplierNumber;
	}

	public void setSupplierNumber(int supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	@Column(name = "supplier_name", length = 200)
	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name = "kind_attn", length = 100)
	public String getKindAttn() {
		return this.kindAttn;
	}

	public void setKindAttn(String kindAttn) {
		this.kindAttn = kindAttn;
	}

	@Column(name = "contact_number")
	public Integer getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "mobile_number")
	public Integer getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "email_id", length = 50)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "gst_number", length = 50)
	public String getGstNumber() {
		return this.gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	@Column(name = "payment_term", length = 50)
	public String getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	@Column(name = "payment_mode", length = 50)
	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Column(name = "document", length = 400)
	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@Column(name = "address", length = 400)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "account_number")
	public Integer getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "bank_name", length = 200)
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "ifsc_code", length = 50)
	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	//@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "supplierMaster", cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE })
	public List<SupplierDetails> getSupplierDetailses() {
		return this.supplierDetailses;
	}

	public void setSupplierDetailses(List<SupplierDetails> supplierDetailses) {
		this.supplierDetailses = supplierDetailses;
	}

}