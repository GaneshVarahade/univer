package com.Univerclassroom.dao;

import java.util.List;

import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.School;
import com.Univerclassroom.model.SchoolAdmin;


public interface SchoolDao {

	
	public boolean addSchool(School school) throws Exception;
	
	public School geSchoolById(long SchoolId) throws Exception;
	public List<School> getSchools() throws Exception ;
}

