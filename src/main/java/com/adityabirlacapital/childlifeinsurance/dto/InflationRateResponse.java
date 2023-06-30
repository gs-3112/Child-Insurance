/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InflationRateResponse {
	private Integer inflationRateId;
	private Integer inflationRate;
	private String createdBy;
	private String modifiedBy;
	private LocalDateTime modifiedDate;
	private LocalDateTime createdDate;
	private Boolean active;

}
