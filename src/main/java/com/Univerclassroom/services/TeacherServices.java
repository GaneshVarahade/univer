package com.Univerclassroom.services;

import java.util.List;

import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.Teacher;

public interface TeacherServices {

	boolean TeacherLogin(TeacherDTO tDTO);
	public Teacher getTeacherByUsername(String username);
	Teacher getTeacherById(long SchoolAdminId) throws Exception;
	void updateTeacherField(TeacherDTO tDTO,Teacher t);
	boolean checkUsername(String username);	
	List<Teacher> getTeacherListById(long id);
	boolean deleteTeacher(long id);
	
}
