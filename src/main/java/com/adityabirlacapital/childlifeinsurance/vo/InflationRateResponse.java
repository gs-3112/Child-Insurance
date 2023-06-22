/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InflationRateResponse {
	private Integer inflationRateId;
	private Integer inflationRate;

}
