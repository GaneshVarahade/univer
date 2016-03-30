package com.Univerclassroom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.SchoolAdminDao;
import com.Univerclassroom.dao.SchoolDao;
import com.Univerclassroom.model.School;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("schoolServices")

public class SchoolServicesImpl implements SchoolServices{

	@Autowired
	SchoolDao schoolDao;

	
	
	@Override
	public boolean addSchool(School school) throws Exception {
		schoolDao.addSchool(school);
		return false;
	}

}
