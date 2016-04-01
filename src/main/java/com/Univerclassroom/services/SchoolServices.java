package com.Univerclassroom.services;

import java.util.List;

import com.Univerclassroom.model.School;

public interface SchoolServices {

	public List<School> getSchools() throws Exception ;
	public School geSchoolById(long SchoolId) throws Exception;
	public boolean addSchool(School school) throws Exception;
}
