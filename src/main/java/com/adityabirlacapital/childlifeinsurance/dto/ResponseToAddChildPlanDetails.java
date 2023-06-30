package com.adityabirlacapital.childlifeinsurance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(value = { "duplicateRecord" })
public class ResponseToAddChildPlanDetails extends ChildPlanDetailsResponse{

    private Boolean duplicateRecord = false;
}
