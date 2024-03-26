package com.snipe.let.admin.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employee")
public class EmployeeDomain implements Serializable {

	private static final long serialVersionUID = 385216499646932497L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "genderId")
	private int genderId;

	@ManyToOne
	@JoinColumn(name = "countryId")
	private CountryDomain countryDomain;

	@ManyToOne
	@JoinColumn(name = "stateId")
	private StateDomain stateDomain;

	@ManyToOne
	@JoinColumn(name = "cityId")
	private CityDomain cityDomain;

	@Column(name = "street")
	private String street;

	@Column(name = "doorNumber")
	private String doorNumber;

	@Column(name = "mobileNumber")
	private BigInteger mobileNumber;

	@Column(name = "alternativeNumber")
	private BigInteger alternativeNumber;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "password")
	private String password;

	@Column(name = "confirmPassword")
	private String confirmPassword;

	@Column(name = "status", nullable = false)
	private Boolean status;

	@Column(name = "tokenId")
	private String tokenId;

	@Column(name = "webToken")
	private String webToken;

	@Column(name = "creationDate")
	@CreationTimestamp
	private LocalDateTime creationDate;

	@Column(name = "modificationDate")
	@UpdateTimestamp
	private LocalDateTime modificationDate;
	
	@Column(name = "aadharNumber")
	private BigInteger aadharNumber;
	
	@Column(name = "accountNumber")
	private BigInteger accountNumber;
	
	@ManyToOne
	@JoinColumn(name = "bankId")
	private BankDomain bankDomain;
	
	@Column(name = "ifscCode")
	private String ifscCode;
	
	@Column(name= "panNumber")
	private String panNumber;
	
	@Column(name= "profileId")
	private long profileId;
	
	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public BankDomain getBankDomain() {
		return bankDomain;
	}

	public void setBankDomain(BankDomain bankDomain) {
		this.bankDomain = bankDomain;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public CountryDomain getCountryDomain() {
		return countryDomain;
	}

	public void setCountryDomain(CountryDomain countryDomain) {
		this.countryDomain = countryDomain;
	}

	public StateDomain getStateDomain() {
		return stateDomain;
	}

	public void setStateDomain(StateDomain stateDomain) {
		this.stateDomain = stateDomain;
	}

	public CityDomain getCityDomain() {
		return cityDomain;
	}

	public void setCityDomain(CityDomain cityDomain) {
		this.cityDomain = cityDomain;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public BigInteger getAlternativeNumber() {
		return alternativeNumber;
	}

	public void setAlternativeNumber(BigInteger alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getWebToken() {
		return webToken;
	}

	public void setWebToken(String webToken) {
		this.webToken = webToken;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public BigInteger getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(BigInteger aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public BigInteger getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}
		
}