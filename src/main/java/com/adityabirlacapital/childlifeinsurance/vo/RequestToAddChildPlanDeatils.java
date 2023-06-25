package com.adityabirlacapital.childlifeinsurance.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestToAddChildPlanDeatils {

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
	private Boolean active;
	private Double expensesFinal;
	private Double saveAmount;
}
