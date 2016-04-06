package com.Univerclassroom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.DTO.ParentDTO;
import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.dao.ParentDao;
import com.Univerclassroom.model.Parent;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("parentServices")
public class ParentServicesImpl implements ParentServices{

	@Autowired
	ParentDao parentDao;

	@Override
	public boolean addOrUpdateParent(Parent parent) {
		return parentDao.addOrUpdateParent(parent);
	}

	@Override
	public Parent getParent(StudentAdmissionDTO sad) {
		return parentDao.getParent(sad);
	}

	@Override
	public boolean checkUsername(String username) {
		return parentDao.checkUsername(username);
	}

	@Override
	public Parent getParentByUsername(String username) {
		return parentDao.getParentByUsername(username);
	}

	@Override
	public boolean login(ParentDTO parent) {
		return parentDao.login(parent);
	}
	
	
}