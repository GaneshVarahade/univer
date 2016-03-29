package com.Univerclassroom.services;


import java.util.List;

import com.Univerclassroom.model.Admin;

import com.Univerclassroom.model.SchoolAdmin;


public interface SchoolAdminServices {

	
	
	
		public boolean addSchoolAdmin(SchoolAdmin Schooladmin) throws Exception;
		
		public SchoolAdmin getSchoolAdminByUsername(String username);
		public boolean login(SchoolAdmin Schooladmin);
		
		public boolean checkUsername(SchoolAdmin Schooladmin);		


	}

