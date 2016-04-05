package com.Univerclassroom.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Required;

import com.Univerclassroom.DTO.SchoolAdminDTO;

@Entity
@Table(name = "SchoolAdmin")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class SchoolAdmin implements Serializable{


	@Id
	@GeneratedValue
	@Column(name = "SchoolAdminId")
	private long SchoolAdminId;
	
	

	@Column(name=" Username")
	private String  Username;	

	@Column(name=" Password")
	private String  Password;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="SchoolAdminId")
	private Set<Librarian> librarian;

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="SchoolAdminId")
	private Set<Teacher> teacher;


    public School getSchool() {
		return school;
	}
	public Set<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}
	public Set<Librarian> getLibrarian() {
		return librarian;
	}
	public void setLibrarian(Set<Librarian> librarian) {
		this.librarian = librarian;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@OneToOne()
    @JoinColumn(name="SchoolId")
       private School school;
    

    
			@ManyToOne
	private Admin  admin;

	public SchoolAdmin(){
		
	}
	public SchoolAdmin(SchoolAdminDTO SchoolAdminDTO){
		
		this.Username=SchoolAdminDTO.getUsername();
		this.Password=SchoolAdminDTO.getPassword();	
		
		
	}

	
	
	public long getSchoolAdminId() {
		return SchoolAdminId;
	}
	public void setSchoolAdminId(long schoolAdminId) {
		SchoolAdminId = schoolAdminId;
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public HashMap<String, String> getHashmap() {
		// TODO Auto-generated method stub
		return null;
	}
}
