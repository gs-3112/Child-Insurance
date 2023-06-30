package com.adityabirlacapital.childlifeinsurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_Customer")
public class Customer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "MobileNumber")
	private String mobileNumber;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "DOB")
	private String dateOfBirth;

	@OneToMany(mappedBy = "customer")
	private List<Kyc> kycCoustomer;

	@OneToMany(mappedBy = "customer")
	private List<ChildPlan> childPlans;
	
	@Column(name = "PanNumber")
	private String panNumber;

	@Column(name = "AdharNumber")
	private String adharNumber;

	@Column(name = "Email")
	private String email;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Landmark")
	private String landmark;

	@Column(name = "Pincode")
	private String pincode;

	@Column(name = "CompanyName")
	private String companyName;

	@Column(name = "NriCustomer")
	private boolean nriCustomer;

	@Column(name = "MonthlyIncome")
	private String monthlyIncome;

	@Column(name = "LoanAmount")
	private String loanAmount;

	@Column(name = "Createdby")
	private String createdby;

	@Column(name = "Createddate")
	private String createddate;

	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Column(name = "ModififedDate")
	private String modififedDate;

	@Column(name = "Active")
	private String active;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the kycCoustomer
	 */
	public List<Kyc> getKycCoustomer() {
		return kycCoustomer;
	}

	/**
	 * @param kycCoustomer the kycCoustomer to set
	 */
	public void setKycCoustomer(List<Kyc> kycCoustomer) {
		this.kycCoustomer = kycCoustomer;
	}

	/**
	 * @return the childPlans
	 */
	public List<ChildPlan> getChildPlans() {
		return childPlans;
	}

	/**
	 * @param childPlans the childPlans to set
	 */
	public void setChildPlans(List<ChildPlan> childPlans) {
		this.childPlans = childPlans;
	}

	/**
	 * @return the panNumber
	 */
	public String getPanNumber() {
		return panNumber;
	}

	/**
	 * @param panNumber the panNumber to set
	 */
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	/**
	 * @return the adharNumber
	 */
	public String getAdharNumber() {
		return adharNumber;
	}

	/**
	 * @param adharNumber the adharNumber to set
	 */
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * @param landmark the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the nriCustomer
	 */
	public boolean isNriCustomer() {
		return nriCustomer;
	}

	/**
	 * @param nriCustomer the nriCustomer to set
	 */
	public void setNriCustomer(boolean nriCustomer) {
		this.nriCustomer = nriCustomer;
	}

	/**
	 * @return the monthlyIncome
	 */
	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	/**
	 * @param monthlyIncome the monthlyIncome to set
	 */
	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	/**
	 * @return the loanAmount
	 */
	public String getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}

	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	/**
	 * @return the createddate
	 */
	public String getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modififedDate
	 */
	public String getModififedDate() {
		return modififedDate;
	}

	/**
	 * @param modififedDate the modififedDate to set
	 */
	public void setModififedDate(String modififedDate) {
		this.modififedDate = modififedDate;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	
	
	
}

