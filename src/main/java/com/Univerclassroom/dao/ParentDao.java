package com.Univerclassroom.dao;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Parent;

@Proxy(lazy=false)
public interface ParentDao {

	boolean addOrUpdateParent(Parent parent);
	Parent getParent(StudentAdmissionDTO sad);
}