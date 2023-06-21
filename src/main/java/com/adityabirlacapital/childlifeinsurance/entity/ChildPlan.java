package com.adityabirlacapital.childlifeinsurance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="T_Child_Insurance")
public class ChildPlan {

	@Id
	@Column(name = "LIChildId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer liChildId;
	
	@JsonBackReference
	@ManyToOne
	Customer customer;
	
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
