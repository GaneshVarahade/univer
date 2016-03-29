package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.SchoolAdmin;

@Proxy(lazy=false)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class SchoolAdminDaoImpl implements SchoolAdminDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addSchoolAdmin(SchoolAdmin Schooladmin) throws Exception {
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(Schooladmin);
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return true;		
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean login(SchoolAdmin Schooladmin) {
		 boolean flag=true;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(SchoolAdmin.class);
			c.add(Restrictions.eq("Username", Schooladmin.getUsername()));
			c.add(Restrictions.eq("Password", Schooladmin.getPassword()));
			Object u = c.uniqueResult();
			if(u==null)
			{
				flag=false;
			}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;
	
	}
	/*
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public SchoolAdmin getClientByUsername(String Username) {
		
		Session session;
		SchoolAdmin  user = null;
		try{
			
			
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(SchoolAdmin.class);
			 criteria.add(Restrictions.eq("username", Username));
			 Object result=criteria.uniqueResult();
			 user = (SchoolAdmin)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}*/
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean checkUsername(SchoolAdmin Schooladmin) {
		
		 boolean flag=false;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(SchoolAdmin.class);
			System.out.println(Schooladmin.getUsername());
			c.add(Restrictions.eq("Username", Schooladmin.getUsername()));
			Object o = c.uniqueResult();
	
			if(o==null)
			{
				flag=true;
			}
			
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;
		
	}
	@Override
	public SchoolAdmin getSchoolAdminByUsername(String username) {
		Session session;
		SchoolAdmin  Schooladmin = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(SchoolAdmin.class);
			 criteria.add(Restrictions.eq("Username", username));
			 System.out.println("hello"+username);
			 Object result=criteria.uniqueResult();
			 Schooladmin = (SchoolAdmin)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Schooladmin;
	
	}
	
	
}
