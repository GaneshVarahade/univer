package com.Univerclassroom.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.DTO.ParentDTO;
import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Parent;
import com.Univerclassroom.model.Student;

@Proxy(lazy=false)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ParentDaoImpl implements ParentDao{


	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	boolean flag = false;
	
	@Override
	public boolean addOrUpdateParent(Parent parent) {
		try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(parent);
			flag = true;
			tx.commit();
			session.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;	
	}

	@Override
	public Parent getParent(StudentAdmissionDTO sad) {
		Parent parent = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Parent.class);
		criteria.add(Restrictions.eq("ParentEmailId", sad.getParentEmailId()));
		Object result=criteria.uniqueResult();
		parent = (Parent)result;
		tx.commit();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return parent;

	}

	@Override
	public boolean checkUsername(String username) {
		boolean flag=false;
		 Parent parent = null;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Parent.class);
			c.add(Restrictions.eq("ParentUsername", username));
			Object o = c.uniqueResult();
			parent = (Parent)o;
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
	public Parent getParentByUsername(String username) {
		Session session;
		Parent  parent = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Parent.class);
			 criteria.add(Restrictions.eq("ParentUsername", username));
			 Object result=criteria.uniqueResult();
			 parent = (Parent)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return parent;
	}

	@Override
	public boolean login(ParentDTO parent) {
		boolean flag=true;
	    try{  	
	    session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Parent.class);
		c.add(Restrictions.eq("ParentUsername", parent.getUsername()));
		c.add(Restrictions.eq("ParentPassword", parent.getPassword()));
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

}