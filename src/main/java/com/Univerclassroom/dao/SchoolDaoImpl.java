package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.Univerclassroom.model.Admin;
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

	@Override
	public School geSchoolById(long SchoolId) throws Exception {
		
		session = sessionFactory.openSession();
		School school = (School) session.load(School.class,
				new Long(SchoolId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return school;		
	
		
		
	}

	@Override
	public List<School> getSchools() throws Exception {
		
		
		Session session = sessionFactory.openSession();
		String hql = "from School";
		Query query = session.createQuery(hql);
		List<School> SchoolList  = query.list();
		return SchoolList;
		
		
	}

	
	
}
