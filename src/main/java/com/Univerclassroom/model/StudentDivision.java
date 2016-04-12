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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "StudentDivision")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class StudentDivision implements Serializable{
	
	@Id
	@GeneratedValue
	private long StudentDivisionId;
	
	private String DivisonName;
	
	@ManyToOne
	private StudentClass studentClass;
	
	@OneToOne()
    @JoinColumn(name="Id")
    private Teacher teacher;

	/*@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="StudentId",insertable=true, updatable=true)
	private Set<Student> student;
	
	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}*/

	public long getStudentDivisionId() {
		return StudentDivisionId;
	}

	public void setStudentDivisionId(long studentDivisionId) {
		StudentDivisionId = studentDivisionId;
	}

	public String getDivisonName() {
		return DivisonName;
	}

	public void setDivisonName(String divisonName) {
		DivisonName = divisonName;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
