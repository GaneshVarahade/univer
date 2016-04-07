package com.Univerclassroom.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.AdminDao;
import com.Univerclassroom.dao.SchoolAdminDao;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.AdmissionResult;
import com.Univerclassroom.model.Holiday;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.StudentToParent;
import com.Univerclassroom.model.Teacher;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("Schooladminservices")
public class SchoolAdminServicesImpl implements SchoolAdminServices {

	@Autowired
	SchoolAdminDao Schooladmindao;

	@Override
	public boolean addSchoolAdmin(SchoolAdmin Schooladmin) throws Exception {
		
		return Schooladmindao.addSchoolAdmin(Schooladmin);
	}

	@Override
	public boolean login(SchoolAdmin Schooladmin) {
		
		return  Schooladmindao.login(Schooladmin);
	}

	@Override
	public boolean checkUsername(SchoolAdmin Schooladmin) {
	
		return Schooladmindao.checkUsername(Schooladmin);
	}

	@Override
	public SchoolAdmin getSchoolAdminByUsername(String username) {
		return Schooladmindao.getSchoolAdminByUsername(username);
		}

	@Override
	public List<StudentToParent> getAdmissionList() {
		return Schooladmindao.getAdmissionList();
	}

	@Override
	public StudentToParent getStudentToParentById(long id) {
		return Schooladmindao.getStudentToParentById(id);
	}

	@Override
	public boolean addAdmissionResult(AdmissionResult ar) throws Exception {
		return Schooladmindao.addAdmissionResult(ar);
	}

	@Override
	public SchoolAdmin getSchoolAdminById(long SchoolAdminId) throws Exception {
		
		return Schooladmindao.getSchoolAdminById(SchoolAdminId);
	}

	@Override
	public boolean addTeacher(Teacher teacher) throws Exception {
		return Schooladmindao.addTeacher(teacher);
	}

	@Override
	public boolean addHoliday(Holiday holiday) throws Exception {
		
		return Schooladmindao.addHoliday(holiday) ;
	}
	
}
