package com.Univerclassroom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.StudentDivisonToStudentDao;
import com.Univerclassroom.model.StudentDivisonToStudent;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("studentDivisonToStudentServices")
public class StudentDivisonToStudentServicesImpl implements StudentDivisonToStudentServices{

	@Autowired
	StudentDivisonToStudentDao studentDivisonToStudentDao;
	
	@Override
	public boolean addOrUpdateStudentDivisonToStudent(
			StudentDivisonToStudent sdts) {
		return studentDivisonToStudentDao.addOrUpdateStudentDivisonToStudent(sdts);
	}

	@Override
	public List<StudentDivisonToStudent> getStudentDivisionToStudentbySchoolAdminId(
			long id) {
		return studentDivisonToStudentDao.getStudentDivisionToStudentbySchoolAdminId(id);
	}



}
