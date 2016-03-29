package com.Univerclassroom.services;
import com.Univerclassroom.model.Admin;

import java.util.List;


public interface AdminServices {
	
	boolean isValidEmailAddress(String email);
	public Admin getAdminById(long adminID) throws Exception;
	public List <Admin> getAdminList() throws Exception;
	public boolean deleteAdmin(long adminID) throws Exception;
	boolean addAdmin(Admin admin) throws Exception;
	boolean login(Admin admin);
	public Admin getAdminByUsername(String username);
    boolean checkAdminUsername(Admin admin);

	
	


}
