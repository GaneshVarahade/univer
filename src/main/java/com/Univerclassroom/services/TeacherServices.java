package com.Univerclassroom.services;

import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.model.Teacher;

public interface TeacherServices {

	boolean TeacherLogin(TeacherDTO tDTO);
	public Teacher getTeacherByUsername(String username);
	Teacher getTeacherById(long SchoolAdminId) throws Exception;
	void updateTeacherField(TeacherDTO tDTO,Teacher t);
}
