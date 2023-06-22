package com.adityabirlacapital.childlifeinsurance.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseToGetChildPlanDetails {

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
    private Integer liChildId;
    private Double expensesFinal;
    private Double saveAmount;
    private Boolean active;

}
