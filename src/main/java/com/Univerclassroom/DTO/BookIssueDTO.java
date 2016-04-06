package com.Univerclassroom.DTO;

public class BookIssueDTO {

	private String sessionId;
	private long TeacherId;
	private long StudentId;
	private long UniqueIdentifier;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public long getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(long teacherId) {
		TeacherId = teacherId;
	}
	public long getStudentId() {
		return StudentId;
	}
	public void setStudentId(long studentId) {
		StudentId = studentId;
	}
	public long getUniqueIdentifier() {
		return UniqueIdentifier;
	}
	public void setUniqueIdentifier(long uniqueIdentifier) {
		UniqueIdentifier = uniqueIdentifier;
	}
	
	
	
	
}
