package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.model.FeeStructure;

@Proxy(lazy=false)
public interface FeeStructureDao {
	boolean addFeeStructure(FeeStructure fee) throws Exception;
	boolean checkClassUnique(FeeStructure fee);
    FeeStructure getFeeStructurebyClassname(String classname);
    public List<FeeStructure> getFeeStructureList() throws Exception;
    FeeStructure getFeeStructureById(long id) throws Exception;
    public boolean deleteFeeStructure(long iD) throws Exception;
}
