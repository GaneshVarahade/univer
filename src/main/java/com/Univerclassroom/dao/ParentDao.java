package com.Univerclassroom.dao;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.ParentDTO;
import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.DTO.StudentDTO;
import com.Univerclassroom.model.Parent;
import com.Univerclassroom.model.Student;

@Proxy(lazy=false)
public interface ParentDao {

	boolean addOrUpdateParent(Parent parent);
	Parent getParent(StudentAdmissionDTO sad);
	public boolean checkUsername(String username);	
	public Parent getParentByUsername(String username);
	public boolean login(ParentDTO parent);
}