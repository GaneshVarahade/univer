package com.Univerclassroom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.dao.StudentDao;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentToParent;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("studentServices")
public class StudentServicesImpl implements StudentServices{

	@Autowired
	StudentDao studentDao;
	
	@Override
	public boolean addOrUpdateStudent(Student student) {
		return studentDao.addOrUpdateStudent(student);
	}

	@Override
	public boolean addOrUpdateStudentToParent(StudentToParent stp) {
		return studentDao.addOrUpdateStudentToParent(stp);
	}

	@Override
	public Student getStudent(StudentAdmissionDTO sad) {
		return studentDao.getStudent(sad);
	}

	@Override
	public boolean checkStudentUnique(Student student) {
		return studentDao.checkStudentUnique(student);
	}

	@Override
	public boolean checkRollNo(String rollNo) {
		return studentDao.checkRollNo(rollNo);
	}

	@Override
	public boolean checkUsername(String username) {
		return studentDao.checkUsername(username);
	}

	@Override
	public List<Student> getStudentListBySchoolAdminId(long scoolAdminId)
			throws Exception {
		return studentDao.getStudentListBySchoolAdminId(scoolAdminId);
	}

	
 
}