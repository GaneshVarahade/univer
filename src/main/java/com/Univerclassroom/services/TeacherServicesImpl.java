package com.Univerclassroom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.dao.TeacherDao;
import com.Univerclassroom.model.BookIssue;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.Teacher;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("teacherServices")
public class TeacherServicesImpl implements TeacherServices {

	@Autowired
	TeacherDao teacherDao;
	
	@Override
	public boolean TeacherLogin(TeacherDTO tDTO) {
	     return teacherDao.TeacherLogin(tDTO);
	}

	@Override
	public Teacher getTeacherByUsername(String username) {
		return teacherDao.getTeacherByUsername(username);
	}

	@Override
	public Teacher getTeacherById(long teacherId) throws Exception {
		return teacherDao.getTeacherById(teacherId);
	}

	@Override
	public void updateTeacherField(TeacherDTO tDTO, Teacher t) {
		teacherDao.updateTeacherField(tDTO, t);
		
	}

	@Override
	public boolean checkUsername(String username) {
		return teacherDao.checkUsername(username);
	}

	@Override
	public List<Teacher> getTeacherListById(long id) {
		return teacherDao.getTeacherListById(id);
	}

	@Override
	public boolean deleteTeacher(long id) {
		return teacherDao.deleteTeacher(id);
	}

	@Override
	public BookIssue getBookIssuedByTeacherId(long Id, long UniqueIdentifier)
			throws Exception {
		return teacherDao.getBookIssuedByTeacherId(Id, UniqueIdentifier);
	}

	
	
}
