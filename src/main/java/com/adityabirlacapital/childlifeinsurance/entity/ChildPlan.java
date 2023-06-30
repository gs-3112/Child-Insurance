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
//@Table(name="T_Child_Insurance")
@Table(name="T_Child_Insurance",uniqueConstraints={
		@UniqueConstraint(columnNames = {"customerId","childName", "childAge","goalType","goalAmt","goalTenure","expensesFinal","roi","saveAmount","tenure"})
})
public class ChildPlan {

	@Id
	@Column(name = "LIChildId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long liChildId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customerId")
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
	private Double goalTenure;
	
	@Column(name="expensesFinal")
	private Long expensesFinal;

	@Column(name="roi")
	private Double roi;

	@Column(name="saveAmount")
	private Long saveAmount;

	@Column(name="tenure")
	private Double tenure;

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
	
	@Column(name="active",columnDefinition = "boolean default true")
	boolean active = true;

	@Column(name="isInterestedInPlan",columnDefinition = "boolean default false")
	boolean isInterestedInPlan = false;

}
