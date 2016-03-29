package com.Univerclassroom.services;

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Parent;

public interface ParentServices {
	boolean addOrUpdateParent(Parent parent);
	Parent getParent(StudentAdmissionDTO sad);
}