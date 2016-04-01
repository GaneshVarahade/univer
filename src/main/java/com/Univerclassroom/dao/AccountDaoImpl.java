package com.Univerclassroom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.model.Account;
import com.Univerclassroom.model.Admin;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class AccountDaoImpl implements AccountDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addAccount(Account account) throws Exception {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(account);
			flag = true;
			tx.commit();
			session.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;	
	}

	@Override
	public Account getAccountById(long Id) throws Exception {
		session = sessionFactory.openSession();
		Account account = (Account) session.load(Account.class,
				new Long(Id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return account;		
	}

}
