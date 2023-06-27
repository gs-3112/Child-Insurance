package com.adityabirlacapital.childlifeinsurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseToAddChildPlanDetails {

	private Long customerId;
	private String childName;
	private Integer childAge;
	private String goalType;
	private Double goalAmt;
	private Double goalTenure;
	private Double tenure;
	private Double roi;
	private String createdBy;
	private String modifiedBy;
	private LocalDateTime modifiedDate;
	private LocalDateTime createdDate;
	
	/*
	 * Need to calculate below fields
	 */
	private Integer liChildId;
	private Long expensesFinal;
	private Long saveAmount;
	private Boolean active;
}
