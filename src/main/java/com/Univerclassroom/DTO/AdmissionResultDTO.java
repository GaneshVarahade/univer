package com.Univerclassroom.DTO;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdmissionResultDTO {

	private long admissionId;
	private double mark;
	private int rank;
	private boolean eligible;
	private String sessionId;
	
	public long getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(long admissionId) {
		this.admissionId = admissionId;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public boolean isEligible() {
		return eligible;
	}
	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}
}
