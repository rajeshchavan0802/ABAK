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

/**
 * PanelSpecification generated by hbm2java
 */
@Entity
@Table(name = "panel_specification", catalog = "abak")
public class PanelSpecification implements java.io.Serializable,Cloneable {

	private Integer panelSpecificationId;
	private Panel panel;
	private int projectId;
	private String specificationType;
	private String specificationDescription;
	private String specificationValue;
	private String specificationValue1;

	public PanelSpecification() {
	}

	public PanelSpecification(Panel panel, int projectId) {
		this.panel = panel;
		this.projectId = projectId;
	}

	public PanelSpecification(Panel panel, int projectId, String specificationType, String specificationDescription,
			String specificationValue, String specificationValue1) {
		this.panel = panel;
		this.projectId = projectId;
		this.specificationType = specificationType;
		this.specificationDescription = specificationDescription;
		this.specificationValue = specificationValue;
		this.specificationValue1 = specificationValue1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Panel_specification_id", unique = true, nullable = false)
	public Integer getPanelSpecificationId() {
		return this.panelSpecificationId;
	}

	public void setPanelSpecificationId(Integer panelSpecificationId) {
		this.panelSpecificationId = panelSpecificationId;
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

	@Column(name = "specification_type", length = 100)
	public String getSpecificationType() {
		return this.specificationType;
	}

	public void setSpecificationType(String specificationType) {
		this.specificationType = specificationType;
	}

	@Column(name = "specification_description", length = 100)
	public String getSpecificationDescription() {
		return this.specificationDescription;
	}

	public void setSpecificationDescription(String specificationDescription) {
		this.specificationDescription = specificationDescription;
	}

	@Column(name = "specification_value", length = 100)
	public String getSpecificationValue() {
		return this.specificationValue;
	}

	public void setSpecificationValue(String specificationValue) {
		this.specificationValue = specificationValue;
	}

	@Column(name = "specification_value1", length = 100)
	public String getSpecificationValue1() {
		return this.specificationValue1;
	}

	public void setSpecificationValue1(String specificationValue1) {
		this.specificationValue1 = specificationValue1;
	}

	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
}
