package com.Univerclassroom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.StudentClassDao;
import com.Univerclassroom.model.StudentClass;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("studentClassServices")
public class StudentClassServicesImpl implements StudentClassServices{

	@Autowired
	StudentClassDao studentClassDao;
	
	@Override
	public boolean addStudentClass(StudentClass studentClass) throws Exception {
		return studentClassDao.addStudentClass(studentClass);
	}

}
