package com.Univerclassroom.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "Account")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Account implements Serializable{

	@Id
	@GeneratedValue
	private long Id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "stpId", insertable = true, updatable = true, nullable = true, unique = true)
	private StudentToParent Stp;
	
	private ArrayList<String> PaymentRecipt;
	
	private ArrayList<Integer> PaidFee;
	
	private long RemainingFee;
	
	private String NextDate;
	
	private boolean AdmissionConfirm;


	@ManyToOne
    private SchoolAdmin  schoolAdmin;
	
	public SchoolAdmin getSchoolAdmin() {
		return schoolAdmin;
	}

	public void setSchoolAdmin(SchoolAdmin schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public StudentToParent getStp() {
		return Stp;
	}

	public void setStp(StudentToParent stp) {
		Stp = stp;
	}

	public ArrayList<String> getPaymentRecipt() {
		return PaymentRecipt;
	}

	public void setPaymentRecipt(ArrayList<String> paymentRecipt) {
		PaymentRecipt = paymentRecipt;
	}

	public ArrayList<Integer> getPaidFee() {
		return PaidFee;
	}

	public void setPaidFee(ArrayList<Integer> paidFee) {
		PaidFee = paidFee;
	}

	public long getRemainingFee() {
		return RemainingFee;
	}

	public void setRemainingFee(long remainingFee) {
		RemainingFee = remainingFee;
	}

	public String getNextDate() {
		return NextDate;
	}

	public void setNextDate(String nextDate) {
		NextDate = nextDate;
	}

	public boolean isAdmissionConfirm() {
		return AdmissionConfirm;
	}

	public void setAdmissionConfirm(boolean admissionConfirm) {
		AdmissionConfirm = admissionConfirm;
	}
}
