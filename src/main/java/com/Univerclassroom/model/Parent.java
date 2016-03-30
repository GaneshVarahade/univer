package com.Univerclassroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.StudentAdmissionDTO;

@Entity
@Table(name = "Parent")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Parent {
	
	@Id
	@GeneratedValue
	private long ParentId;
	
	private String FatherFirstName;
	private String FatherLastName;
	private String MotherFirstName;
	private String MotherLastName;
	private String GuardianFirstName;
	private String GuardianLastName;
	private String FatherOccupation;
	private String MotherOccupation;
	private String FatherAnnualIncome;
	private String ParentEmailId;
	
	public long getParentId() {
		return ParentId;
	}
	public void setParentId(long parentId) {
		ParentId = parentId;
	}
	public String getFatherFirstName() {
		return FatherFirstName;
	}
	public void setFatherFirstName(String fatherFirstName) {
		FatherFirstName = fatherFirstName;
	}
	public String getFatherLastName() {
		return FatherLastName;
	}
	public void setFatherLastName(String fatherLastName) {
		FatherLastName = fatherLastName;
	}
	public String getMotherFirstName() {
		return MotherFirstName;
	}
	public void setMotherFirstName(String motherFirstName) {
		MotherFirstName = motherFirstName;
	}
	public String getMotherLastName() {
		return MotherLastName;
	}
	public void setMotherLastName(String motherLastName) {
		MotherLastName = motherLastName;
	}
	public String getGuardianFirstName() {
		return GuardianFirstName;
	}
	public void setGuardianFirstName(String guardianFirstName) {
		GuardianFirstName = guardianFirstName;
	}
	public String getGuardianLastName() {
		return GuardianLastName;
	}
	public void setGuardianLastName(String guardianLastName) {
		GuardianLastName = guardianLastName;
	}
	public String getFatherOccupation() {
		return FatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		FatherOccupation = fatherOccupation;
	}
	public String getMotherOccupation() {
		return MotherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		MotherOccupation = motherOccupation;
	}
	public String getFatherAnnualIncome() {
		return FatherAnnualIncome;
	}
	public void setFatherAnnualIncome(String fatherAnnualIncome) {
		FatherAnnualIncome = fatherAnnualIncome;
	}
	public String getParentEmailId() {
		return ParentEmailId;
	}
	public void setParentEmailId(String parentEmailId) {
		ParentEmailId = parentEmailId;
	}
	
	public Parent(){
		
	}

	public Parent(StudentAdmissionDTO s){
		this.FatherFirstName = s.getFatherFirstName();
		this.FatherLastName = s.getFatherLastName();
		this.MotherFirstName = s.getMotherFirstName();
		this.MotherLastName = s.getMotherLastName();
		this.GuardianFirstName = s.getGuardianFirstName();
		this.GuardianLastName = s.getGuardianLastName();
		this.FatherOccupation = s.getFatherOccupation();
		this.MotherOccupation = s.getMotherOccupation();
		this.FatherAnnualIncome = s.getFatherAnnualIncome();
		this.ParentEmailId = s.getParentEmailId();
	}
	
}
