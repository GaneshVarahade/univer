package com.Univerclassroom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.StudentDivisionDao;
import com.Univerclassroom.model.StudentDivision;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("studentDivisionService")
public class StudentDivisionServicesImpl implements StudentDivisionServices{

	@Autowired
	StudentDivisionDao studentDivisionDao;
	
	@Override
	public boolean addStudentDivision(StudentDivision studentClass)
			throws Exception {
		return studentDivisionDao.addStudentDivision(studentClass);
	}

	@Override
	public boolean deleteStudentDivision(long studentClassId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StudentDivision> getStudentDivisionListByStudentClassId(
			long studentClassId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkStudentDivisionUnique(StudentDivision studClass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudentDivision getStudentDivisionById(long id) throws Exception {
		return studentDivisionDao.getStudentDivisionById(id);
	}

}
