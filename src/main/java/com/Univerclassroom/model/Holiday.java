package com.Univerclassroom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.HolidayDTO;


@Entity
@Table(name = "Holiday")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Holiday implements Serializable {

	
	@Id
	@GeneratedValue
	@Column(name = "HolidayId")
	private long HolidayId;
	
	@Column(name = "HolidayName")
	private String HolidayName;
		
	@Column(name = "HolidayDate")
	private String HolidayDate;

	@ManyToOne
	private SchoolAdmin schoolAdmin;
	
	
	
	public Holiday(){
		
	}
	
	public Holiday(HolidayDTO holidayDTO){
		
		this.HolidayName=holidayDTO.getHolidayName();
		this.HolidayDate=holidayDTO.getHolidayDate();
	}
	
	public SchoolAdmin getSchoolAdmin() {
		return schoolAdmin;
	}

	public void setSchoolAdmin(SchoolAdmin schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}

	public long getHolidayId() {
		return HolidayId;
	}

	public void setHolidayId(long holidayId) {
		HolidayId = holidayId;
	}

	public String getHolidayName() {
		return HolidayName;
	}

	public void setHolidayName(String holidayName) {
		HolidayName = holidayName;
	}

	public String getHolidayDate() {
		return HolidayDate;
	}

	public void setHolidayDate(String holidayDate) {
		HolidayDate = holidayDate;
	}
	
	
}
