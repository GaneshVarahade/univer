package com.Univerclassroom.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.StudentAdmissionDTO;

@Entity
@Table(name = "Student")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Student implements Serializable{
	
	@Id
	@GeneratedValue
	private long StudentId;
	
	private String StudentFirstName;
	private String StudentLastName;
	private String Nationality;
	private String State;
	private String LocalAddress;
	private String LocalAddressPin;
	private String PermanentAddress;
	private String PermanentAddressPin;
	private String DOB;
	private String DOBPlace;
	private String DOBDistrict;
	private String DOBState;
	private String BloodGroup;
	private String LastSchool;
	private String LastResult;
	private String LastClass;
	private String ClassAdmission;
	private String Medium;
	private boolean isAdmission;
	private boolean PhysicallyHandicapped;
	private String StudentEmailId;
	private String Gendar;
	private String RollNo;
	private String StudentUsername;
	private String StudentPassword;
	private boolean divisionAssigned;
	
	@ManyToOne
	private SchoolAdmin  Schooladmin;

	/*@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private StudentDivision studentDivision;
	
	public StudentDivision getStudentDivision() {
		return studentDivision;
	}

	public void setStudentDivision(StudentDivision studentDivision) {
		this.studentDivision = studentDivision;
	}*/

	public SchoolAdmin getSchooladmin() {
		return Schooladmin;
	}

	public void setSchooladmin(SchoolAdmin schooladmin) {
		Schooladmin = schooladmin;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getStudentUsername() {
		return StudentUsername;
	}

	public void setStudentUsername(String studentUsername) {
		StudentUsername = studentUsername;
	}

	public String getStudentPassword() {
		return StudentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}

	public boolean isAdmission() {
		return isAdmission;
	}

	public void setAdmission(boolean isAdmission) {
		this.isAdmission = isAdmission;
	}

	public String getStudentEmailId() {
		return StudentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		StudentEmailId = studentEmailId;
	}

	public String getGendar() {
		return Gendar;
	}

	public void setGendar(String gendar) {
		Gendar = gendar;
	}

	public long getStudentId() {
		return StudentId;
	}

	public void setStudentId(long studentId) {
		StudentId = studentId;
	}

	public String getStudentFirstName() {
		return StudentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		StudentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return StudentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		StudentLastName = studentLastName;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getLocalAddress() {
		return LocalAddress;
	}

	public void setLocalAddress(String localAddress) {
		LocalAddress = localAddress;
	}

	public String getLocalAddressPin() {
		return LocalAddressPin;
	}

	public void setLocalAddressPin(String localAddressPin) {
		LocalAddressPin = localAddressPin;
	}

	public String getPermanentAddress() {
		return PermanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		PermanentAddress = permanentAddress;
	}

	public String getPermanentAddressPin() {
		return PermanentAddressPin;
	}

	public void setPermanentAddressPin(String permanentAddressPin) {
		PermanentAddressPin = permanentAddressPin;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getDOBPlace() {
		return DOBPlace;
	}

	public void setDOBPlace(String dOBPlace) {
		DOBPlace = dOBPlace;
	}

	public String getDOBDistrict() {
		return DOBDistrict;
	}

	public void setDOBDistrict(String dOBDistrict) {
		DOBDistrict = dOBDistrict;
	}

	public String getDOBState() {
		return DOBState;
	}

	public void setDOBState(String dOBState) {
		DOBState = dOBState;
	}

	public String getBloodGroup() {
		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	public String getLastSchool() {
		return LastSchool;
	}

	public void setLastSchool(String lastSchool) {
		LastSchool = lastSchool;
	}

	public String getLastResult() {
		return LastResult;
	}

	public void setLastResult(String lastResult) {
		LastResult = lastResult;
	}

	public String getLastClass() {
		return LastClass;
	}

	public void setLastClass(String lastClass) {
		LastClass = lastClass;
	}

	public String getClassAdmission() {
		return ClassAdmission;
	}

	public void setClassAdmission(String classAdmission) {
		ClassAdmission = classAdmission;
	}

	public String getMedium() {
		return Medium;
	}

	public void setMedium(String medium) {
		Medium = medium;
	}

	public boolean isPhysicallyHandicapped() {
		return PhysicallyHandicapped;
	}

	public void setPhysicallyHandicapped(boolean physicallyHandicapped) {
		PhysicallyHandicapped = physicallyHandicapped;
	}


	public boolean isDivisionAssigned() {
		return divisionAssigned;
	}

	public void setDivisionAssigned(boolean divisionAssigned) {
		this.divisionAssigned = divisionAssigned;
	}

	
	public Student(){
		
	}

	public Student(StudentAdmissionDTO s){
		this.StudentFirstName = s.getStudentFirstName();
		this.StudentLastName = s.getStudentLastName();
		this.Gendar = s.getGender();
		this.StudentEmailId = s.getStudentEmailId();
		this.Nationality  = s.getNationality();
		this.State = s.getState();
		this.LocalAddress = s.getLocalAddress();
		this.PermanentAddress = s.getPermanentAddress();
		this.LocalAddressPin = s.getLocalAddressPin();
		this.PermanentAddressPin = s.getPermanentAddressPin();
		this.DOB = s.getDob();
		this.DOBPlace = s.getDobPlace();
		this.DOBDistrict = s.getDobDistrict();
		this.DOBState = s.getDobState();
		this.BloodGroup = s.getBloodGroup();
		this.ClassAdmission = s.getClassAdmission();
		this.isAdmission = s.isAdmission();
		this.LastSchool = s.getLastSchool();
		this.LastClass = s.getLastClass();
		this.LastResult = s.getLastResult();
		this.Medium = s.getMedium();
		this.PhysicallyHandicapped = s.isPhysicallyHandicapped();
	}

	
	
	
}
