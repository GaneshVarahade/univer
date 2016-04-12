package com.Univerclassroom.model;

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
@Table(name = "StudentToStudentDivision")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class StudentDivisonToStudent {
	
	
	@Id
	@GeneratedValue
	private long Id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "StudentId", insertable = true, updatable = true, nullable = true, unique = true)
	private Student student;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "StudentDivisionId", insertable = true, updatable = true, nullable = true, unique = true)
	private StudentDivision studentDivisionId;

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDivision getStudentDivisionId() {
		return studentDivisionId;
	}

	public void setStudentDivisionId(StudentDivision studentDivisionId) {
		this.studentDivisionId = studentDivisionId;
	}
}
