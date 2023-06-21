package com.adityabirlacapital.childlifeinsurance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_Kyc")
public class Kyc {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonBackReference
	@ManyToOne
	Customer customer;

	@Column(name = "PermanentAddress")
	private String permanentAddress;

	@Column(name = "DigilockerStatus")
	private String digilockerStatus;

	@Column(name = "DigilockerCreatedDate")
	private String digilockerCreatedDate;

	@Column(name = "VideoKYC")
	private String videoKYC;

	@Column(name = "LastFetchedDT")
	private String lastFetchedDT;
}
