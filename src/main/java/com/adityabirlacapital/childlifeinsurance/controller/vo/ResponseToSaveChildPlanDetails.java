package com.adityabirlacapital.childlifeinsurance.controller.vo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseToSaveChildPlanDetails {

	private Long customerId;
	private String childName;
	private Integer childAge;
	private String goalType;
	private Double goalAmt;
	private Integer goalTenure;
	private Integer tenure;
	private Integer roi;
	private String createdBy;
	private String modifiedBy;
	private LocalDateTime modifiedDate;
	private LocalDateTime createdDate;
	
	/*
	 * Need to calculate below fields
	 */
	private Integer liChildId;
	private Double expensesFinal;
	private Double saveAmount;

	private String active;

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the childName
	 */
	public String getChildName() {
		return childName;
	}

	/**
	 * @param childName the childName to set
	 */
	public void setChildName(String childName) {
		this.childName = childName;
	}

	/**
	 * @return the childAge
	 */
	public Integer getChildAge() {
		return childAge;
	}

	/**
	 * @param childAge the childAge to set
	 */
	public void setChildAge(Integer childAge) {
		this.childAge = childAge;
	}

	/**
	 * @return the goalType
	 */
	public String getGoalType() {
		return goalType;
	}

	/**
	 * @param goalType the goalType to set
	 */
	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}

	/**
	 * @return the goalAmt
	 */
	public Double getGoalAmt() {
		return goalAmt;
	}

	/**
	 * @param goalAmt the goalAmt to set
	 */
	public void setGoalAmt(Double goalAmt) {
		this.goalAmt = goalAmt;
	}

	/**
	 * @return the goalTenure
	 */
	public Integer getGoalTenure() {
		return goalTenure;
	}

	/**
	 * @param goalTenure the goalTenure to set
	 */
	public void setGoalTenure(Integer goalTenure) {
		this.goalTenure = goalTenure;
	}

	/**
	 * @return the tenure
	 */
	public Integer getTenure() {
		return tenure;
	}

	/**
	 * @param tenure the tenure to set
	 */
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	/**
	 * @return the roi
	 */
	public Integer getRoi() {
		return roi;
	}

	/**
	 * @param roi the roi to set
	 */
	public void setRoi(Integer roi) {
		this.roi = roi;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the liChildId
	 */
	public Integer getLiChildId() {
		return liChildId;
	}

	/**
	 * @param liChildId the liChildId to set
	 */
	public void setLiChildId(Integer liChildId) {
		this.liChildId = liChildId;
	}

	/**
	 * @return the expensesFinal
	 */
	public Double getExpensesFinal() {
		return expensesFinal;
	}

	/**
	 * @param expensesFinal the expensesFinal to set
	 */
	public void setExpensesFinal(Double expensesFinal) {
		this.expensesFinal = expensesFinal;
	}

	/**
	 * @return the saveAmount
	 */
	public Double getSaveAmount() {
		return saveAmount;
	}

	/**
	 * @param saveAmount the saveAmount to set
	 */
	public void setSaveAmount(Double saveAmount) {
		this.saveAmount = saveAmount;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the modifiedDate
	 */
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
