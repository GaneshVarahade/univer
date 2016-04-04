package com.Univerclassroom.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.LibrarianDTO;

@Entity
@Table(name = "Librarian")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Librarian {


	@Id
@GeneratedValue
@Column(name = "LibrarianId")
private long LibrarianId;

@Column(name= "Username")
private String  Username;	

@Column(name= "Password")
private String  Password;



@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="LibrarianId")
private Set<Book> book;


@ManyToOne
private SchoolAdmin  schoolAdmin;


public Librarian()
{
	
}

public Librarian(LibrarianDTO librarianDTO)
{
   this.Username=librarianDTO.getUsername();
   this.Password=librarianDTO.getPassword();
  
	
}

public long getLibrarianId() {
	return LibrarianId;
}


public SchoolAdmin getSchoolAdmin() {
	return schoolAdmin;
}


public void setSchoolAdmin(SchoolAdmin schoolAdmin) {
	this.schoolAdmin = schoolAdmin;
}


public Set<Book> getBook() {
	return book;
}

public void setBook(Set<Book> book) {
	this.book = book;
}

public void setLibrarianId(long librarianId) {
	LibrarianId = librarianId;
}


public String getUsername() {
	return Username;
}


public void setUsername(String username) {
	Username = username;
}


public String getPassword() {
	return Password;
}


public void setPassword(String password) {
	Password = password;
}	
	
	
}
