package com.Univerclassroom.services;

import java.util.List;

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

	@Override
	public boolean deleteStudentClass(long studentClassId) throws Exception {
		return studentClassDao.deleteStudentClass(studentClassId);
	}

	@Override
	public List<StudentClass> getStudentClassListBySchoolAdminId(
			long scoolAdminId) throws Exception {
		return studentClassDao.getStudentClassListBySchoolAdminId(scoolAdminId);
	}

	@Override
	public boolean checkStudentClassUnique(StudentClass studClass) {
		return studentClassDao.checkStudentClassUnique(studClass);
	}

	@Override
	public StudentClass getStudentClassById(long id) throws Exception {
		return studentClassDao.getStudentClassById(id);
	}

}
