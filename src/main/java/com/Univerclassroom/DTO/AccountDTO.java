package com.Univerclassroom.DTO;

public class AccountDTO {

	private String sessionId;
	private Integer admissionId;
	private String paymentReceipt;
	private Integer paidFee;
	private Integer remainingFee;
	private String nextDate;
	private boolean admissionConfirm;
	private String action;
	private String rollNo;
	private String studentUsername;
	private String studentPassword;
	private String parentUsername;
	private String parentPassword;
	private long Id;
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentUsername() {
		return studentUsername;
	}
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public String getParentUsername() {
		return parentUsername;
	}
	public void setParentUsername(String parentUsername) {
		this.parentUsername = parentUsername;
	}
	public String getParentPassword() {
		return parentPassword;
	}
	public void setParentPassword(String parentPassword) {
		this.parentPassword = parentPassword;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(Integer admissionId) {
		this.admissionId = admissionId;
	}
	public String getPaymentReceipt() {
		return paymentReceipt;
	}
	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}
	public Integer getPaidFee() {
		return paidFee;
	}
	public void setPaidFee(Integer paidFee) {
		this.paidFee = paidFee;
	}
	public Integer getRemainingFee() {
		return remainingFee;
	}
	public void setRemainingFee(Integer remainingFee) {
		this.remainingFee = remainingFee;
	}
	public String getNextDate() {
		return nextDate;
	}
	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
	}
	public boolean isAdmissionConfirm() {
		return admissionConfirm;
	}
	public void setAdmissionConfirm(boolean admissionConfirm) {
		this.admissionConfirm = admissionConfirm;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	
}
