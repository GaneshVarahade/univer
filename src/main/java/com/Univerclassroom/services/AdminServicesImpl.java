package com.Univerclassroom.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.AdminDao;
import com.Univerclassroom.model.Admin;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("adminservices")
public class AdminServicesImpl implements AdminServices {

	@Autowired
	AdminDao admindao;
	
	

	@Override
	public boolean isValidEmailAddress(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean checkAdminUsername(Admin admin)
	{
		
		return admindao.checkAdminUsername(admin);
	}
	
	@Override
	public Admin getAdminById(long adminID) throws Exception {
		return admindao.getAdminById(adminID);
		
	}

	@Override
	public List<Admin> getAdminList() throws Exception {
		return admindao.getAdminList();
		
	}

	@Override
	public boolean deleteAdmin(long adminID) throws Exception {
		return admindao.deleteAdmin(adminID);
		}
	@Override
	public boolean addAdmin(Admin admin) throws Exception
	{
		return admindao.addAdmin(admin);
	}


	@Override
	public boolean login(Admin admin) {
		return admindao.login(admin);
	}


	@Override
	public Admin getAdminByUsername(String username) {
		return admindao.getAdminByUsername(username);
	}
	
}
