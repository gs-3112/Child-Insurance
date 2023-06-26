package com.adityabirlacapital.childlifeinsurance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestToAddChildPlanDeatils {

	@NotNull(message = "should not be null")
	private Long customerId;
	@NotBlank(message = "should not be blank")
	private String childName;
	@NotNull(message = "should not be null")
	private Integer childAge;
	@NotBlank(message = "should not be blank")
	private String goalType;
	@NotNull(message = "should not be null")
	private Double goalAmt;
	@NotNull(message = "should not be null")
	private Integer goalTenure;
	@NotNull(message = "should not be null")
	private Integer tenure;
	@NotNull(message = "should not be null")
	private Integer roi;
	@NotBlank(message = "should not be blank")
	private String createdBy;
	@NotBlank(message = "should not be blank")
	private String modifiedBy;
	@NotNull(message = "should not be null")
	private Double expensesFinal;
	@NotNull(message = "should not be null")
	private Double saveAmount;
}
