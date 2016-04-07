package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.BookIssue;
import com.Univerclassroom.model.Teacher;

@Proxy(lazy=false)
public interface TeacherDao {
	boolean TeacherLogin(TeacherDTO tDTO);
	public Teacher getTeacherByUsername(String username);
	Teacher getTeacherById(long teacherId) throws Exception;
	void updateTeacherField(TeacherDTO tDTO,Teacher t);
	boolean checkUsername(String username);	
	List<Teacher> getTeacherListById(long id);
	boolean deleteTeacher(long id);
	public BookIssue getBookIssuedByTeacherId(long TeacherId,long UniqueIdentifier) throws Exception;
}	
