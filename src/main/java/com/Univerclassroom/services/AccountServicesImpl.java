package com.Univerclassroom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.AccountDao;
import com.Univerclassroom.dao.FeeStructureDao;
import com.Univerclassroom.model.Account;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("accountservices")
public class AccountServicesImpl implements AccountServices{

	@Autowired
	AccountDao accountDao;
	
	@Override
	public boolean addAccount(Account account) throws Exception {
		return accountDao.addAccount(account);
	}

	@Override
	public Account getAccountById(long Id) throws Exception {
		return accountDao.getAccountById(Id);
	}

}
