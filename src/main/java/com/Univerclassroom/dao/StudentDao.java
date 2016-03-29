package com.Univerclassroom.dao;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentToParent;

@Proxy(lazy=false)
public interface StudentDao {

	boolean addOrUpdateStudent(Student student);
	boolean addOrUpdateStudentToParent(StudentToParent stp);
	Student getStudent(StudentAdmissionDTO sad);
}