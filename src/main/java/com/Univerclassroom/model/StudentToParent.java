package com.Univerclassroom.model;

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


@Entity
@Table(name = "StudentToParent")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)

public class StudentToParent {

	@Id
	@GeneratedValue
	private long Id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "StudentId", insertable = true, updatable = true, nullable = true, unique = true)
	private Student student;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ParentId", insertable = true, updatable = true, nullable = true, unique = true)
	private Parent parent;


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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
}
