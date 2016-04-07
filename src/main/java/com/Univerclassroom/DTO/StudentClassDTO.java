package com.Univerclassroom.DTO;

public class StudentClassDTO {

	private String sessionId;
	private String className;
	private String action;
	private long studentClassId;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public long getStudentClassId() {
		return studentClassId;
	}
	public void setStudentClassId(long studentClassId) {
		this.studentClassId = studentClassId;
	}

}
