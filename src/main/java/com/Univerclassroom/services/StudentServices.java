package com.Univerclassroom.services;

import java.util.List;

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.DTO.StudentDTO;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentToParent;

public interface StudentServices {

	boolean addOrUpdateStudent(Student student);
	boolean addOrUpdateStudentToParent(StudentToParent stp);
	Student getStudent(StudentAdmissionDTO sad);
	boolean checkStudentUnique(Student student);
	public boolean checkRollNo(String  rollNo);
	public boolean checkUsername(String username);	
	public List<Student> getStudentListBySchoolAdminId(long scoolAdminId) throws Exception ;
	public Student getStudentById(long StudentId) throws Exception;
	public Student getStudentByUsername(String username);
	public boolean login(StudentDTO student);
	
}