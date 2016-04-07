package com.Univerclassroom.dao;

import java.util.List;

import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.AdmissionResult;
import com.Univerclassroom.model.Holiday;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.StudentToParent;
import com.Univerclassroom.model.Teacher;


public interface SchoolAdminDao {
	public boolean addSchoolAdmin(SchoolAdmin Schooladmin) throws Exception;
	public boolean addHoliday(Holiday holiday) throws Exception;
	public boolean login(SchoolAdmin Schooladmin);
	public SchoolAdmin getSchoolAdminById(long SchoolAdminId) throws Exception;
	public SchoolAdmin getSchoolAdminByUsername(String username);
	public boolean checkUsername(SchoolAdmin Schooladmin);		
    List<StudentToParent> getAdmissionList();
    public StudentToParent getStudentToParentById(long id);
    public boolean addAdmissionResult(AdmissionResult ar) throws Exception;
    public boolean addTeacher(Teacher teacher) throws Exception;
}