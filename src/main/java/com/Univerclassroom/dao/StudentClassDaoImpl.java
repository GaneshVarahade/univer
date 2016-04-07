package com.Univerclassroom.dao;

import java.util.ArrayList;
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

	@Override
	public boolean deleteStudentClass(long studentClassId) throws Exception {
		boolean flag = false;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(StudentClass.class, studentClassId);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		flag = true;
		tx.commit();
		session.close();
		}
		catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public List<StudentClass> getStudentClassListBySchoolAdminId(
			long scoolAdminId) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria c = session.createCriteria(StudentClass.class);
		c.createAlias("schoolAdmin", "sadmin");
		c.add(Restrictions.eq("sadmin.SchoolAdminId", scoolAdminId));
		List<StudentClass> studentClassList = c.list();
		tx.commit();
		session.close();
		return studentClassList;
	}

	@Override
	public boolean checkStudentClassUnique(StudentClass studClass) {
		boolean flag = false;
		List<StudentClass> list = new ArrayList<StudentClass>();
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
		String hql = "from StudentClass where ClassName =:classname";
		Query query = session.createQuery(hql);
		query.setString("classname", studClass.getClassName());
		list = query.list();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    if(list.isEmpty()){
	    	flag = true;
	    }else{
	    	flag = false;
	    }
	    return flag;
	}

	@Override
	public StudentClass getStudentClassById(long id) throws Exception {
		session = sessionFactory.openSession();
		StudentClass studClass = (StudentClass) session.load(StudentClass.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return studClass;
	}

}
