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
import org.springframework.beans.factory.annotation.Autowired;

import com.Univerclassroom.DTO.BookIssueDTO;
import com.Univerclassroom.services.LibrarianServices;
import com.Univerclassroom.services.StudentServices;
import com.Univerclassroom.services.TeacherServices;


@Entity
@Table(name = "BookIssue")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class BookIssue {

	
	@Id
	@GeneratedValue
	private long Id;
	
	

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "StudentId", insertable = true, updatable = true, nullable = true, unique = true)
	private Student student;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TeacherId", insertable = true, updatable = true, nullable = true, unique = true)
	private Teacher teacher;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "UniqueIdentifier", insertable = true, updatable = true, nullable = true, unique = true)
	private Book book;

	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	
}
