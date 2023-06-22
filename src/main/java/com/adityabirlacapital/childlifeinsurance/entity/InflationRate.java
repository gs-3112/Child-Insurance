/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="T_LI_INFLATION_RATES")
public class InflationRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inflationRateId")
	private Integer inflationRateId;
	
	@Column(name = "inflationRate")
	private Integer inflationRate;

	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name = "modifiedBy")
	private String modifiedBy;

	@Column(name = "modifiedDate")
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	@Column(name = "createdDate")
	@CreatedDate
	private LocalDateTime createdDate;
	
	@Column(name="active")
	boolean active;

}
