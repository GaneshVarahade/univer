package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Book;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentToParent;

@Proxy(lazy=false)
public interface StudentDao {

	boolean addOrUpdateStudent(Student student);
	boolean addOrUpdateStudentToParent(StudentToParent stp);
	Student getStudent(StudentAdmissionDTO sad);
	boolean checkStudentUnique(Student student);
	public boolean checkRollNo(String  rollNo);
	public boolean checkUsername(String username);	
	public List<Student> getStudents() throws Exception ;
	
	
}