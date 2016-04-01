package com.Univerclassroom.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.TeacherDTO;

@Entity
@Table(name = "Teacher")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Teacher implements Serializable{
	
	@Id
	@GeneratedValue
	private long Id;
	
	private String teacherFirstName;
	private String teacherLastName;
	private String teacherUsername;
	private String teacherPassword	;
	private String gender;
	private String emailId;
	private Integer mobileNo;
	private String address;
	private String subjectProficiency;
	private String maritalstatus;
	private String certification;
	private ArrayList<String> teachingClass;

	@ManyToOne
	private SchoolAdmin  schoolAdmin;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ExperienceId")
	private Set<Experience> experience;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="EducationId")
	private Set<Education> education;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public SchoolAdmin getSchoolAdmin() {
		return schoolAdmin;
	}

	public void setSchoolAdmin(SchoolAdmin schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}

	public Set<Experience> getExperience() {
		return experience;
	}

	public void setExperience(Set<Experience> experience) {
		this.experience = experience;
	}

	public Set<Education> getEducation() {
		return education;
	}

	public void setEducation(Set<Education> education) {
		this.education = education;
	}

	public String getTeacherFirstName() {
		return teacherFirstName;
	}

	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}

	public String getTeacherLastName() {
		return teacherLastName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	public String getTeacherUsername() {
		return teacherUsername;
	}

	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubjectProficiency() {
		return subjectProficiency;
	}

	public void setSubjectProficiency(String subjectProficiency) {
		this.subjectProficiency = subjectProficiency;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public ArrayList<String> getTeachingClass() {
		return teachingClass;
	}

	public void setTeachingClass(ArrayList<String> teachingClass) {
		this.teachingClass = teachingClass;
	}
	
	public Teacher(){
		
	}
	
    public Teacher(TeacherDTO teacherDTO){
		this.teacherFirstName = teacherDTO.getTeacherFirstName();
		this.teacherLastName = teacherDTO.getTeacherLastName();
		this.teacherUsername = teacherDTO.getTeacherUsername();
		this.teacherPassword = teacherDTO.getTeacherPassword();
	}
}
