package com.Univerclassroom.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.AdmissionResultDTO;


@Entity
@Table(name = "AdmissionResult")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class AdmissionResult implements Serializable {


	@Id
	@GeneratedValue
	private long Id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "admissionId", insertable = true, updatable = true, nullable = true, unique = true)
	private StudentToParent stp;
	
	private double mark;
	
	private int rank;

	private boolean eligible;
	
	

	public double getMark() {
		return mark;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	
	public StudentToParent getStp() {
		return stp;
	}

	public void setStp(StudentToParent stp) {
		this.stp = stp;
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

	public boolean isEligible() {
		return eligible;
	}

	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}
	
	public AdmissionResult(){
		
	}
	
	public AdmissionResult(AdmissionResultDTO ard){
		this.eligible=ard.isEligible();
		this.mark=ard.getMark();
		this.rank=ard.getRank();
	}
}
