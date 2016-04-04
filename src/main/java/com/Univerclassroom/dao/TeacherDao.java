package com.Univerclassroom.dao;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.model.Teacher;

@Proxy(lazy=false)
public interface TeacherDao {
	boolean TeacherLogin(TeacherDTO tDTO);
	public Teacher getTeacherByUsername(String username);
	Teacher getTeacherById(long teacherId) throws Exception;
	void updateTeacherField(TeacherDTO tDTO,Teacher t);
}	
