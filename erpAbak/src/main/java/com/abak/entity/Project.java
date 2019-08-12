package com.abak.entity;
// Generated 3 Jun, 2019 12:29:30 PM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "project")
public class Project implements Cloneable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7562940658158896109L;
	private Integer projectId;
	private String projectName;
	private Integer customerId;
	private String status;
	private Integer numbersOfPanels;
	private Integer numbersOfPanelTypes;
	private Double totalCostActual;
	private Double quetationCost;
	private Double finalCost;
	private String paymentRecieve;
	private Integer enquiryNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enquiryRecDate;

	private String enquiryType;
	private String handledByName;
	private Integer handledById;
	private String projectDetails;
	private String documentPathBySalse;
	private String documentPathByEstimator;
	private String consultantName;
	private String consultantencyName;
	private String kindAttPerson;
	private String kindAttPersonEmail;
	private String technicalContactPerson;
	private Integer jobNumber;
	private Integer serialNumber;
	private Integer revisionNumber;
	private Integer estimatorUserId;
	private String estimatorUserName;
	private Integer draftmanId;
	private String draftmanName;
	private Integer schemaDesignerId;
	private String schemaDesignerName;
	private Integer createdBy;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;

	private Integer updatedBy;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedOn;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date quotationSentDate;

	private String typesOfPanel;
	private Date drawingAprvDate;
	private Boolean isEstimationCreated;
	private Boolean isQuotationPresent;
	private String uniqueIdentity;
	
	
	private List<Panel> panels = new ArrayList<Panel>(0);
	
	
	 
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "project_id", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "project_name", length = 100)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "numbers_of_panels")
	public Integer getNumbersOfPanels() {
		return this.numbersOfPanels;
	}

	public void setNumbersOfPanels(Integer numbersOfPanels) {
		this.numbersOfPanels = numbersOfPanels;
	}

	@Column(name = "numbers_of_panel_types")
	public Integer getNumbersOfPanelTypes() {
		return this.numbersOfPanelTypes;
	}

	public void setNumbersOfPanelTypes(Integer numbersOfPanelTypes) {
		this.numbersOfPanelTypes = numbersOfPanelTypes;
	}

	@Column(name = "total_cost_actual", precision = 22, scale = 0)
	public Double getTotalCostActual() {
		return this.totalCostActual;
	}

	public void setTotalCostActual(Double totalCostActual) {
		this.totalCostActual = totalCostActual;
	}

	@Column(name = "quetation_cost", precision = 22, scale = 0)
	public Double getQuetationCost() {
		return this.quetationCost;
	}

	public void setQuetationCost(Double quetationCost) {
		this.quetationCost = quetationCost;
	}

	@Column(name = "final_cost", precision = 22, scale = 0)
	public Double getFinalCost() {
		return this.finalCost;
	}

	public void setFinalCost(Double finalCost) {
		this.finalCost = finalCost;
	}

	@Column(name = "payment_recieve", length = 50)
	public String getPaymentRecieve() {
		return this.paymentRecieve;
	}

	public void setPaymentRecieve(String paymentRecieve) {
		this.paymentRecieve = paymentRecieve;
	}

	@Column(name = "enquiry_number")
	public Integer getEnquiryNumber() {
		return this.enquiryNumber;
	}

	public void setEnquiryNumber(Integer enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "enquiry_rec_date", length = 10)
	public Date getEnquiryRecDate() {
		return this.enquiryRecDate;
	}

	public void setEnquiryRecDate(Date enquiryRecDate) {
		this.enquiryRecDate = enquiryRecDate;
	}

	@Column(name = "enquiry_type", length = 50)
	public String getEnquiryType() {
		return this.enquiryType;
	}

	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}

	@Column(name = "handled_by_name", length = 100)
	public String getHandledByName() {
		return this.handledByName;
	}

	public void setHandledByName(String handledByName) {
		this.handledByName = handledByName;
	}

	@Column(name = "handled_by_id")
	public Integer getHandledById() {
		return this.handledById;
	}

	public void setHandledById(Integer handledById) {
		this.handledById = handledById;
	}

	@Column(name = "project_details", length = 400)
	public String getProjectDetails() {
		return this.projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Column(name = "document_path_by_salse", length = 200)
	public String getDocumentPathBySalse() {
		return this.documentPathBySalse;
	}

	public void setDocumentPathBySalse(String documentPathBySalse) {
		this.documentPathBySalse = documentPathBySalse;
	}

	@Column(name = "document_path_by_estimator", length = 200)
	public String getDocumentPathByEstimator() {
		return this.documentPathByEstimator;
	}

	public void setDocumentPathByEstimator(String documentPathByEstimator) {
		this.documentPathByEstimator = documentPathByEstimator;
	}

	@Column(name = "consultant_name", length = 100)
	public String getConsultantName() {
		return this.consultantName;
	}

	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}

	@Column(name = "consultantency_name", length = 100)
	public String getConsultantencyName() {
		return this.consultantencyName;
	}

	public void setConsultantencyName(String consultantencyName) {
		this.consultantencyName = consultantencyName;
	}

	@Column(name = "kind_att_person", length = 100)
	public String getKindAttPerson() {
		return this.kindAttPerson;
	}

	public void setKindAttPerson(String kindAttPerson) {
		this.kindAttPerson = kindAttPerson;
	}

	@Column(name = "kind_att_person_email", length = 100)
	public String getKindAttPersonEmail() {
		return this.kindAttPersonEmail;
	}

	public void setKindAttPersonEmail(String kindAttPersonEmail) {
		this.kindAttPersonEmail = kindAttPersonEmail;
	}

	@Column(name = "technical_contact_person", length = 100)
	public String getTechnicalContactPerson() {
		return this.technicalContactPerson;
	}

	public void setTechnicalContactPerson(String technicalContactPerson) {
		this.technicalContactPerson = technicalContactPerson;
	}

	@Column(name = "job_number")
	public Integer getJobNumber() {
		return this.jobNumber;
	}

	public void setJobNumber(Integer jobNumber) {
		this.jobNumber = jobNumber;
	}

	@Column(name = "serial_number")
	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name = "revision_number")
	public Integer getRevisionNumber() {
		return this.revisionNumber;
	}

	public void setRevisionNumber(Integer revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	@Column(name = "estimator_user_id")
	public Integer getEstimatorUserId() {
		return this.estimatorUserId;
	}

	public void setEstimatorUserId(Integer estimatorUserId) {
		this.estimatorUserId = estimatorUserId;
	}

	@Column(name = "estimator_user_name", length = 100)
	public String getEstimatorUserName() {
		return this.estimatorUserName;
	}

	public void setEstimatorUserName(String estimatorUserName) {
		this.estimatorUserName = estimatorUserName;
	}

	@Column(name = "draftman_id")
	public Integer getDraftmanId() {
		return this.draftmanId;
	}

	public void setDraftmanId(Integer draftmanId) {
		this.draftmanId = draftmanId;
	}

	@Column(name = "draftman_name", length = 100)
	public String getDraftmanName() {
		return this.draftmanName;
	}

	public void setDraftmanName(String draftmanName) {
		this.draftmanName = draftmanName;
	}

	@Column(name = "Schema_designer_id")
	public Integer getSchemaDesignerId() {
		return this.schemaDesignerId;
	}

	public void setSchemaDesignerId(Integer schemaDesignerId) {
		this.schemaDesignerId = schemaDesignerId;
	}

	@Column(name = "Schema_designer_name", length = 100)
	public String getSchemaDesignerName() {
		return this.schemaDesignerName;
	}

	public void setSchemaDesignerName(String schemaDesignerName) {
		this.schemaDesignerName = schemaDesignerName;
	}

	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_on", length = 10)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_on", length = 10)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "quotation_sent_date", length = 10)
	public Date getQuotationSentDate() {
		return this.quotationSentDate;
	}

	public void setQuotationSentDate(Date quotationSentDate) {
		this.quotationSentDate = quotationSentDate;
	}

	@Column(name = "types_of_panel", length = 200)
	public String getTypesOfPanel() {
		return this.typesOfPanel;
	}

	public void setTypesOfPanel(String typesOfPanel) {
		this.typesOfPanel = typesOfPanel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "drawing_aprv_date", length = 10)
	public Date getDrawingAprvDate() {
		return this.drawingAprvDate;
	}

	public void setDrawingAprvDate(Date drawingAprvDate) {
		this.drawingAprvDate = drawingAprvDate;
	}
	
	@Column(name = "isEstimationCreated")
	public Boolean getIsEstimationCreated() {
		return this.isEstimationCreated;
	}

	public void setIsEstimationCreated(Boolean isEstimationCreated) {
		this.isEstimationCreated = isEstimationCreated;
	}

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = {CascadeType.ALL})
	public List<Panel> getPanels() {
		return this.panels;
	}

	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}

	@Column(name = "isQuotationPresent")
	public Boolean getIsQuotationPresent() {
		return this.isQuotationPresent;
	}

	public void setIsQuotationPresent(Boolean isQuotationPresent) {
		this.isQuotationPresent = isQuotationPresent;
	}
	
	@Column(name = "uniqueIdentity", length = 200)
	public String getUniqueIdentity() {
		return this.uniqueIdentity;
	}

	public void setUniqueIdentity(String uniqueIdentity) {
		this.uniqueIdentity = uniqueIdentity;
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  

}
