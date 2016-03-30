package com.Univerclassroom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.FeeStructureDao;
import com.Univerclassroom.model.FeeStructure;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("feeStructureServices")
public class FeeStructureServicesImpl implements FeeStructureServices{

	@Autowired
	FeeStructureDao feeStructureDao;
	
	@Override
	public boolean addFeeStructure(FeeStructure fee) throws Exception {
		return feeStructureDao.addFeeStructure(fee);
	}

	@Override
	public boolean checkClassUnique(FeeStructure fee) {
		return feeStructureDao.checkClassUnique(fee);
	}

	@Override
	public FeeStructure getFeeStructurebyClassname(String classname) {
		return feeStructureDao.getFeeStructurebyClassname(classname);
	}

	@Override
	public List<FeeStructure> getFeeStructureList() throws Exception {
		return feeStructureDao.getFeeStructureList();
	}

	@Override
	public FeeStructure getFeeStructureById(long id) throws Exception {
		return feeStructureDao.getFeeStructureById(id);
	}

	@Override
	public boolean deleteFeeStructure(long iD) throws Exception {
		return feeStructureDao.deleteFeeStructure(iD);
	}

}
