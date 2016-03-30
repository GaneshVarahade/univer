package com.Univerclassroom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.Univerclassroom.model.School;

public class SchoolDaoImpl implements SchoolDao {

	
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addSchool(School school) throws Exception {
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(school);
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return true;		
	
	}

	
	
}
