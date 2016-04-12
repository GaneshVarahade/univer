package com.Univerclassroom.services;

import java.util.List;

import com.Univerclassroom.model.StudentDivisonToStudent;

public interface StudentDivisonToStudentServices {

	boolean addOrUpdateStudentDivisonToStudent(StudentDivisonToStudent sdts);
	List<StudentDivisonToStudent> getStudentDivisionToStudentbySchoolAdminId(long id);
}
