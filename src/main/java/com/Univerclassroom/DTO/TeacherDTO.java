package com.Univerclassroom.DTO;

import java.util.Set;

import com.Univerclassroom.model.Education;
import com.Univerclassroom.model.Experience;

public class TeacherDTO {

	private long teacherId;
	private String action;
	private String sessionId;
	private String teacherFirstName;
	private String teacherLastName;
	private String teacherUsername;
	private String teacherPassword;
	
	private String gender;
	private String emailId;
	private Integer mobileNo;
	private String address;
	private String subjectProficiency;
	private String maritalstatus;
	private String certification;
	
	private Set<Experience> experience;
	
	private Set<Education> education;
	
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
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
}
