package com.Univerclassroom.DTO;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolAdminDTO {
	
	private long    SchoolAdminId;
	private String  Username;		
	private String  Password;
	private String sessionId;
	public long getSchoolAdminId() {
		return SchoolAdminId;
	}
	public void setSchoolAdminId(long schoolAdminId) {
		SchoolAdminId = schoolAdminId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	
	
	
	
	
	}