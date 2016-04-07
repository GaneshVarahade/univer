package com.Univerclassroom.services;

import java.util.List;

import com.Univerclassroom.model.StudentDivision;

public interface StudentDivisionServices {
	boolean addStudentDivision(StudentDivision studentClass)throws Exception;
	boolean deleteStudentDivision(long studentClassId) throws Exception;
	List<StudentDivision> getStudentDivisionListByStudentClassId(long studentClassId) throws Exception ;
	boolean checkStudentDivisionUnique(StudentDivision studClass);
	StudentDivision getStudentDivisionById(long id) throws Exception;
}
