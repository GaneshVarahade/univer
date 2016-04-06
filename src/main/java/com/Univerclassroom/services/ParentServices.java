package com.Univerclassroom.services;

import com.Univerclassroom.DTO.ParentDTO;
import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Parent;

public interface ParentServices {
	boolean addOrUpdateParent(Parent parent);
	Parent getParent(StudentAdmissionDTO sad);
	public boolean checkUsername(String username);	
	public Parent getParentByUsername(String username);
	public boolean login(ParentDTO parent);
}