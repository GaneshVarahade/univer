package com.Univerclassroom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.model.StudentClass;

@Proxy(lazy=false)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class StudentClassDaoImpl implements StudentClassDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addStudentClass(StudentClass studentClass) throws Exception {
		 boolean flag = false;
		    try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(studentClass);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;			
	}

}
