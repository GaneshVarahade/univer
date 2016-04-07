package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.model.StudentClass;

@Proxy(lazy=false)
public interface StudentClassDao {

	boolean addStudentClass(StudentClass studentClass)throws Exception;
	boolean deleteStudentClass(long studentClassId) throws Exception;
	List<StudentClass> getStudentClassListBySchoolAdminId(long scoolAdminId) throws Exception ;
	boolean checkStudentClassUnique(StudentClass studClass);
}
