package com.adityabirlacapital.childlifeinsurance.controller.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
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
