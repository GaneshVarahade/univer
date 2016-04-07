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
import com.Univerclassroom.model.AdmissionResult;
import com.Univerclassroom.model.Holiday;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.StudentToParent;
import com.Univerclassroom.model.Teacher;

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
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(Schooladmin);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
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
			 Object result=criteria.uniqueResult();
			 Schooladmin = (SchoolAdmin)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Schooladmin;
	
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<StudentToParent> getAdmissionList() {
		Session session;
		List<StudentToParent> stpList = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(StudentToParent.class);
			criteria.createAlias("student", "stud");
			 criteria.add(Restrictions.eq("stud.isAdmission", false));
			 stpList = criteria.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stpList;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public StudentToParent getStudentToParentById(long id) {
		Session session;
		StudentToParent  stp = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(StudentToParent.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 stp = (StudentToParent)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stp;
	
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addAdmissionResult(AdmissionResult ar) throws Exception {
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(ar);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;	
	}
	@Override
	public SchoolAdmin getSchoolAdminById(long SchoolAdminId) throws Exception {
		
		session = sessionFactory.openSession();
		SchoolAdmin schoolAdmin = (SchoolAdmin) session.load(SchoolAdmin.class,
				new Long(SchoolAdminId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return schoolAdmin;	
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addTeacher(Teacher teacher) throws Exception {
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(teacher); 
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
	}
	@Override
	public boolean addHoliday(Holiday holiday) throws Exception {
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(holiday);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
		
		
		
	}
	
	
}
