package com.Univerclassroom.services;

import java.util.List;

import com.Univerclassroom.model.StudentClass;

public interface StudentClassServices {

	boolean addStudentClass(StudentClass studentClass)throws Exception;
	boolean deleteStudentClass(long studentClassId) throws Exception;
	List<StudentClass> getStudentClassListBySchoolAdminId(long scoolAdminId) throws Exception ;
	boolean checkStudentClassUnique(StudentClass studClass);
}
