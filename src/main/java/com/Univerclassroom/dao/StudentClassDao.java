package com.Univerclassroom.dao;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.model.StudentClass;

@Proxy(lazy=false)
public interface StudentClassDao {

	boolean addStudentClass(StudentClass studentClass)throws Exception;
}
