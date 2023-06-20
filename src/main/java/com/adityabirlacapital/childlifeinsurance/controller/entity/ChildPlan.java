package com.adityabirlacapital.childlifeinsurance.controller.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="TLIChildInsurance")
public class ChildPlan {

	@Id
	@Column(name = "LIChildId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer liChildId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "person_id")
	private Customer personId;
	
	@Column(name = "childName")
	private String childName;
	
	@Column(name="childAge")
	private Integer childAge;
	
	@Column(name="goalType")
	private String goalType;
	
	@Column(name="goalAmt")
	private Double goalAmt;
	
	@Column(name="goalTenure")
	private Integer goalTenure;
	
	@Column(name="expensesFinal")
	private Double expensesFinal;

	@Column(name="roi")
	private Integer roi;

	@Column(name="saveAmount")
	private Double saveAmount;

	@Column(name="tenure")
	private Integer tenure;

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
