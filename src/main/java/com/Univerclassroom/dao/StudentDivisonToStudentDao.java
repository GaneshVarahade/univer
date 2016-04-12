package com.Univerclassroom.dao;

import java.util.List;

import com.Univerclassroom.model.StudentDivisonToStudent;

public interface StudentDivisonToStudentDao {

	boolean addOrUpdateStudentDivisonToStudent(StudentDivisonToStudent sdts);
	List<StudentDivisonToStudent> getStudentDivisionToStudentbySchoolAdminId(long id);
}
