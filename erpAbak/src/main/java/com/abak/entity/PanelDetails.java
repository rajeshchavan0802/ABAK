package com.abak.entity;
// Generated 3 Jun, 2019 12:29:30 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * PanelDetails generated by hbm2java
 */
@Entity
@Table(name = "panel_details", catalog = "abak")
public class PanelDetails implements java.io.Serializable,Cloneable {

	private Integer panelDetailsId;
	private Panel panel;
	private int projectId;
	private String typeOfFeeder;
	private String description;
	private Integer quntity;
	private String type;
	private String make;
	private Double listPrice;
	private Integer discount;
	private Double discountPrice;
	private Double unitRate;
	private Double total;
	private Double wiring;
	private Double labor;
	private String groupName;
	private String feederSubtype;
	

	public PanelDetails() {
	}

	public PanelDetails(Panel panel, int projectId, String typeOfFeeder) {
		this.panel = panel;
		this.projectId = projectId;
		this.typeOfFeeder = typeOfFeeder;
	}

	public PanelDetails(Panel panel, int projectId, String typeOfFeeder, String description, Integer quntity,
			String type, String make, Double listPrice, Integer discount, Double discountPrice, Double unitRate,
			Double total, Double wiring, Double labor) {
		this.panel = panel;
		this.projectId = projectId;
		this.typeOfFeeder = typeOfFeeder;
		this.description = description;
		this.quntity = quntity;
		this.type = type;
		this.make = make;
		this.listPrice = listPrice;
		this.discount = discount;
		this.discountPrice = discountPrice;
		this.unitRate = unitRate;
		this.total = total;
		this.wiring = wiring;
		this.labor = labor;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "panel_details_id", unique = true, nullable = false)
	public Integer getPanelDetailsId() {
		return this.panelDetailsId;
	}

	public void setPanelDetailsId(Integer panelDetailsId) {
		this.panelDetailsId = panelDetailsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "panel_id", nullable = false)
	public Panel getPanel() {
		return this.panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	@Column(name = "project_id")
	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Column(name = "type_of_feeder", length = 50)
	public String getTypeOfFeeder() {
		return this.typeOfFeeder;
	}

	public void setTypeOfFeeder(String typeOfFeeder) {
		this.typeOfFeeder = typeOfFeeder;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "quntity")
	public Integer getQuntity() {
		return this.quntity;
	}

	public void setQuntity(Integer quntity) {
		this.quntity = quntity;
	}

	@Column(name = "type_desc", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "make", length = 50)
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "list_price", precision = 22, scale = 0)
	public Double getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	@Column(name = "discount")
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Column(name = "discount_price", precision = 22, scale = 0)
	public Double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Column(name = "unit_rate", precision = 22, scale = 0)
	public Double getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(Double unitRate) {
		this.unitRate = unitRate;
	}

	@Column(name = "total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Column(name = "wiring", precision = 22, scale = 0)
	public Double getWiring() {
		return this.wiring;
	}

	public void setWiring(Double wiring) {
		this.wiring = wiring;
	}

	@Column(name = "labor", precision = 22, scale = 0)
	public Double getLabor() {
		return this.labor;
	}

	public void setLabor(Double labor) {
		this.labor = labor;
	}

	
	@Column(name = "group_Name", length = 100)
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
 
	
	@Column(name = "feeder_subtype", length = 100)
	public String getFeederSubtype() {
		return this.feederSubtype;
	}

	public void setFeederSubtype(String feederSubtype) {
		this.feederSubtype = feederSubtype;
	}

	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}

}
