package com.Univerclassroom.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "StudentClass")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class StudentClass implements Serializable{

	@Id
	@GeneratedValue
	private long StudentClassId;
	
	private String ClassName;
	
	@ManyToOne
	private SchoolAdmin schoolAdmin;

/*	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="StudentClassId",insertable=true, updatable=true)
	private Set<StudentDivision> studentDivision;
	
	public Set<StudentDivision> getStudentDivision() {
		return studentDivision;
	}

	public void setStudentDivision(Set<StudentDivision> studentDivision) {
		this.studentDivision = studentDivision;
	}
*/
	public long getStudentClassId() {
		return StudentClassId;
	}

	public void setStudentClassId(long studentClassId) {
		StudentClassId = studentClassId;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public SchoolAdmin getSchoolAdmin() {
		return schoolAdmin;
	}

	public void setSchoolAdmin(SchoolAdmin schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}
	
	
}
