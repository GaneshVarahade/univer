package com.Univerclassroom.dao;

import java.util.List;

import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.AdmissionResult;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.StudentToParent;


public interface SchoolAdminDao {
	public boolean addSchoolAdmin(SchoolAdmin Schooladmin) throws Exception;
	public boolean login(SchoolAdmin Schooladmin);
	public SchoolAdmin getSchoolAdminByUsername(String username);
	public boolean checkUsername(SchoolAdmin Schooladmin);		
    List<StudentToParent> getAdmissionList();
    public StudentToParent getStudentToParentById(long id);
    public boolean addAdmissionResult(AdmissionResult ar) throws Exception;
}