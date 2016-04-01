package com.Univerclassroom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.SchoolDTO;


@Entity
@Table(name = "School")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class School implements Serializable {

	
	@Id
	@GeneratedValue
	@Column(name = "SchoolId")
	private long SchoolId;
	
	public SchoolAdmin getSchooladmins() {
		return Schooladmins;
	}

	public void setSchooladmins(SchoolAdmin schooladmins) {
		Schooladmins = schooladmins;
	}

	@Column(name = "SchoolName")
	private String SchoolName;
	
	@Column(name = "PrincipalName")
	private String PrincipalName;
	
	@Column(name = "PrincipalMembershipNumber")
	private String PrincipalMembershipNumber;
	
	@Column(name = "State")
	private String State;

	@Column(name = "Address")
	private String Address;
	
	@Column(name = "PostCode")
	private String PostCode;
	
	@Column(name = "Country")
	private String Country;
	

	@Column(name = "PhoneNumber")
	private String PhoneNumber;
	
	@Column(name = "EmailId")
	private String EmailId;
	
	@Column(name = "SchoolRegistrationDate")
	private String SchoolRegistrationDate;
	
	@Column(name = "SchoolStartDate")
	private String SchoolStartDate;
	
	@Column(name = "WebsiteAddress")
	private String WebsiteAddress;

	@Column(name = "FaxNumber")
	private String FaxNumber;
	
	@Column(name = "SchoolSector")
	private String SchoolSector;
	
	@Column(name = "SchoolSize")
	private String SchoolSize;
	
	@Column(name = "SchoolType")
	private String SchoolType;
	
	@Column(name = "SchoolMedium")
	private String SchoolMedium;

	
	
	@OneToOne(mappedBy="school" , fetch = FetchType.EAGER)
    private SchoolAdmin Schooladmins;
	
	
	
	
	@ManyToOne
	private Admin  admin;

	
	
	
	public School()
	{
	
	}
	
	public School(SchoolDTO schoolDTO)
	{
		this.SchoolName=schoolDTO.getSchoolName();
		this.PrincipalName=schoolDTO.getPrincipalName();
		this.PrincipalMembershipNumber=schoolDTO.getPrincipalMembershipNumber();
		this.State=schoolDTO.getState();
		this.Address=schoolDTO.getAddress();
		this.PostCode=schoolDTO.getPostCode();
		this.Country=schoolDTO.getCountry();
		this.PhoneNumber=schoolDTO.getPhoneNumber();
		this.EmailId=schoolDTO.getEmailId();
		this.SchoolRegistrationDate=schoolDTO.getSchoolRegistrationDate();
		this.SchoolStartDate=schoolDTO.getSchoolStartDate();
		this.WebsiteAddress=schoolDTO.getWebsiteAddress();
		this.FaxNumber=schoolDTO.getFaxNumber();
		this.SchoolSector=schoolDTO.getSchoolSector();
		this.SchoolSize=schoolDTO.getSchoolSize();
		this.SchoolType=schoolDTO.getSchoolType();
		this.SchoolMedium=schoolDTO.getSchoolMedium();

		
	
	}
	
	public long getSchoolId() {
		return SchoolId;
	}

	public void setSchoolId(long schoolId) {
		SchoolId = schoolId;
	}

	public String getSchoolName() {
		return SchoolName;
	}

	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}

	public String getPrincipalName() {
		return PrincipalName;
	}

	public void setPrincipalName(String principalName) {
		PrincipalName = principalName;
	}

	public String getPrincipalMembershipNumber() {
		return PrincipalMembershipNumber;
	}

	public void setPrincipalMembershipNumber(String principalMembershipNumber) {
		PrincipalMembershipNumber = principalMembershipNumber;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPostCode() {
		return PostCode;
	}

	public void setPostCode(String postCode) {
		PostCode = postCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getSchoolRegistrationDate() {
		return SchoolRegistrationDate;
	}

	public void setSchoolRegistrationDate(String schoolRegistrationDate) {
		SchoolRegistrationDate = schoolRegistrationDate;
	}

	public String getSchoolStartDate() {
		return SchoolStartDate;
	}

	public void setSchoolStartDate(String schoolStartDate) {
		SchoolStartDate = schoolStartDate;
	}

	public String getWebsiteAddress() {
		return WebsiteAddress;
	}

	public void setWebsiteAddress(String websiteAddress) {
		WebsiteAddress = websiteAddress;
	}

	public String getFaxNumber() {
		return FaxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		FaxNumber = faxNumber;
	}

	public String getSchoolSector() {
		return SchoolSector;
	}

	public void setSchoolSector(String schoolSector) {
		SchoolSector = schoolSector;
	}

	public String getSchoolSize() {
		return SchoolSize;
	}

	public void setSchoolSize(String schoolSize) {
		SchoolSize = schoolSize;
	}

	public String getSchoolType() {
		return SchoolType;
	}

	public void setSchoolType(String schoolType) {
		SchoolType = schoolType;
	}

	public String getSchoolMedium() {
		return SchoolMedium;
	}

	public void setSchoolMedium(String schoolMedium) {
		SchoolMedium = schoolMedium;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	
	
	
	
	
	
	
	
}


