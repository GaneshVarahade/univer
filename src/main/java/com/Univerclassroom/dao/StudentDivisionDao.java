package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.model.StudentDivision;

@Proxy(lazy=false)
public interface StudentDivisionDao {

	boolean addStudentDivision(StudentDivision studentClass)throws Exception;
	boolean deleteStudentDivision(long studentClassId) throws Exception;
	List<StudentDivision> getStudentDivisionListByStudentClassId(long studentClassId) throws Exception ;
	boolean checkStudentDivisionUnique(StudentDivision studClass);
	StudentDivision getStudentDivisionById(long id) throws Exception;
}
