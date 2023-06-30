package com.adityabirlacapital.childlifeinsurance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChildPlanDetailsRequest {

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
    private Double goalTenure;
    @NotNull(message = "should not be null")
    private Double tenure;
    @NotNull(message = "should not be null")
    private Double roi;
    @NotBlank(message = "should not be blank")
    private String createdBy;
    @NotBlank(message = "should not be blank")
    private String modifiedBy;
}
