package com.Univerclassroom.services;

import java.util.List;

import com.Univerclassroom.model.FeeStructure;

public interface FeeStructureServices {
	boolean addFeeStructure(FeeStructure fee) throws Exception;
	boolean checkClassUnique(FeeStructure fee);
	FeeStructure getFeeStructurebyClassname(String classname);
	public List<FeeStructure> getFeeStructureList() throws Exception;
	FeeStructure getFeeStructureById(long id) throws Exception;
	public boolean deleteFeeStructure(long iD) throws Exception;
}
