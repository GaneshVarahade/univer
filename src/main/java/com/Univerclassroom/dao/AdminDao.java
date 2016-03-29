package com.Univerclassroom.dao;
import com.Univerclassroom.model.Admin;

import java.util.List;

import org.hibernate.annotations.Proxy;


@Proxy(lazy=false)
public interface AdminDao {

	public Admin getAdminById(long adminID) throws Exception;
	public List<Admin> getAdminList() throws Exception;
	public boolean deleteAdmin(long adminID) throws Exception;
	boolean addAdmin(Admin admin) throws Exception;
	public boolean login(Admin admin);
	public Admin getAdminByUsername(String username);
	public boolean checkAdminUsername(Admin admin);		
}
