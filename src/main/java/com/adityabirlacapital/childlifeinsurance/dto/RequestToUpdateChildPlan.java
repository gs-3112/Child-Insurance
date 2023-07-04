package com.adityabirlacapital.childlifeinsurance.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestToUpdateChildPlan {
    @NotBlank(message = "should not be blank")
    private Long childPlanId;
    @NotBlank(message = "should not be blank")
    private Boolean isInterestedInPlan;
    @NotBlank(message = "should not be blank")
    private String modifiedBy;
}
