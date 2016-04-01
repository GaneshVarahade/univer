package com.Univerclassroom.model;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.AdminDTO;

@Entity
@Table(name = "Admin")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;

		@Id
	@GeneratedValue
	@Column(name = "AdminId")
	private long AdminId;
	
	@Column(name= "AdminUsername")
	private String  AdminUsername;	

	@Column(name=" AdminPassword")
	private String  AdminPassword;

	
	
	

public long getAdminId() {
		return AdminId;
	}

	public void setAdminId(long adminId) {
		AdminId = adminId;
	}

	public String getAdminUsername() {
		return AdminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		AdminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

public Admin()
{
	
}

public Admin(AdminDTO adminDTO)
{
	this.AdminUsername=adminDTO.getAdminUsername();
	this.AdminPassword=adminDTO.getAdminPassword();

}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="AdminId")
	private Set<SchoolAdmin> Schooladmin;


	public Set<SchoolAdmin> getSchooladmin() {
		return Schooladmin;
	}

	public void setSchooladmin(Set<SchoolAdmin> schooladmin) {
		Schooladmin = schooladmin;
	}
	


	
    
	
}
