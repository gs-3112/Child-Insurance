package com.adityabirlacapital.childlifeinsurance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestToAddInflationRate {
    @NotNull(message = "should not be null")
    private Integer inflationRate;
    @NotBlank(message = "should not be blank")
    private String createdBy;
    @NotBlank(message = "should not be blank")
    private String modifiedBy;
}
