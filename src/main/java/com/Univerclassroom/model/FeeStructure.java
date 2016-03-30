package com.Univerclassroom.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.FeeStructureDTO;

@Entity
@Table(name = "FeeStructure")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class FeeStructure implements Serializable{
	
	@Id
	@GeneratedValue
	private long Id;
	
	private String ClassName;
	
	private String year;
	
	private long fee;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public long getFee() {
		return fee;
	}

	public void setFee(long fee) {
		this.fee = fee;
	}
	
	public FeeStructure(){
		
	}
	
	public FeeStructure(FeeStructureDTO feeDTO){
		this.ClassName = feeDTO.getClassName();
		this.year = feeDTO.getYear();
		this.fee = feeDTO.getFee();	
	}

}
