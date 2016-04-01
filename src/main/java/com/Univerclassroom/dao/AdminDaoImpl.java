package com.Univerclassroom.dao;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.SchoolAdmin;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
@Proxy(lazy=false)

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class AdminDaoImpl implements AdminDao
{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addAdmin(Admin admin) {
		 boolean flag = false;
		    try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(admin);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;			
		}
	
	@Override
	public Admin getAdminById(long adminID) throws Exception {
		session = sessionFactory.openSession();
		Admin admin = (Admin) session.load(Admin.class,
				new Long(adminID));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return admin;		
	}

	@Override
	public List<Admin> getAdminList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Admin> adminList = session.createCriteria(Admin.class)
.list();
		tx.commit();
		session.close();
		return adminList;
	
	}

	@Override
	public boolean deleteAdmin(long adminID) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Admin.class, adminID);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public boolean login(Admin admin) {
	        boolean flag=true;
	    try{  	
	    session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Admin.class);
		c.add(Restrictions.eq("AdminUsername", admin.getAdminUsername()));
		c.add(Restrictions.eq("AdminPassword", admin.getAdminPassword()));
		Object o = c.uniqueResult();
		if(o==null)
		{
			flag=false;
		}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Admin getAdminByUsername(String username) {
			Session session;
			Admin  admin = null;
			try{
				session = sessionFactory.openSession();
				Criteria criteria = session.createCriteria(Admin.class);
				 criteria.add(Restrictions.eq("AdminUsername", username));
				 System.out.println("hello"+username);
				 Object result=criteria.uniqueResult();
				 admin = (Admin)result;
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return admin;
		}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean checkAdminUsername(Admin admin) {
			
		
		 boolean flag=false;
		    try{  	
		    	System.out.println("hello");
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Admin.class);
			System.out.println(admin.getAdminUsername());
			c.add(Restrictions.eq("adminUsername", admin.getAdminUsername()));
			Object o = c.uniqueResult();
			admin = (Admin)o;
			if(o==null)
			{
				flag=true;
			}
			
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;
		
	}
	
}
