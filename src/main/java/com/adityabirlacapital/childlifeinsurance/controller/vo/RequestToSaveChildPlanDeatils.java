package com.adityabirlacapital.childlifeinsurance.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestToSaveChildPlanDeatils {

	private Integer customerId;
	private String childName;
	private Integer childAge;
	private String goalType;
	private Double goalAmt;
	private Integer goalTenure;
	private Integer tenure;
	private Integer roi;
	private String createdBy;
	private String modifiedBy;
	
	/*
	 * Not sure what is this field for
	 */
	private String active;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Integer getChildAge() {
		return childAge;
	}

	public void setChildAge(Integer childAge) {
		this.childAge = childAge;
	}

	public String getGoalType() {
		return goalType;
	}

	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}

	public Double getGoalAmt() {
		return goalAmt;
	}

	public void setGoalAmt(Double goalAmt) {
		this.goalAmt = goalAmt;
	}

	public Integer getGoalTenure() {
		return goalTenure;
	}

	public void setGoalTenure(Integer goalTenure) {
		this.goalTenure = goalTenure;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Integer getRoi() {
		return roi;
	}

	public void setRoi(Integer roi) {
		this.roi = roi;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	
}
