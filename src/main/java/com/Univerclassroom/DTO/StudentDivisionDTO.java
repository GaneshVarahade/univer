package com.Univerclassroom.DTO;

public class StudentDivisionDTO {

	private String sessionId;
	private String action;
	private String divisionName;
	private long studentClassId;
	private long teacherId;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public long getStudentClassId() {
		return studentClassId;
	}
	public void setStudentClassId(long studentClassId) {
		this.studentClassId = studentClassId;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
}
