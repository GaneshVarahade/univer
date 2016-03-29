package com.Univerclassroom.DTO;

public class AdminDTO {
	
	private long AdminId;
	private String  AdminUsername;
	private String  AdminPassword;
	private String  sessionId;
	public long getAdminId() {
		return AdminId;
	}
	public void setAdminId(long adminId) {
		AdminId = adminId;
	}
	public String getAdminUsername() {
		return AdminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		AdminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
	
	

}

