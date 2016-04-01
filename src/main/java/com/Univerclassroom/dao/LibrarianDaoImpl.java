package com.Univerclassroom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.Univerclassroom.model.Librarian;

public class LibrarianDaoImpl implements LibrarianDao  {

	

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addLibrarian(Librarian librarian) throws Exception {
		
		
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(librarian);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
		
		
	}

	@Override
	public boolean login(Librarian Schooladmin) {
		// TODO Auto-generated method stub
		return false;
	}

}
