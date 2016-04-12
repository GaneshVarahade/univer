package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.model.StudentDivisonToStudent;
import com.Univerclassroom.model.Teacher;


@Proxy(lazy=false)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class StudentDivisonToStudentDaoImpl implements StudentDivisonToStudentDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateStudentDivisonToStudent(
			StudentDivisonToStudent sdts) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(sdts);
			flag = true;
			tx.commit();
			session.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;			

	}

	

	@Override
	public List<StudentDivisonToStudent> getStudentDivisionToStudentbySchoolAdminId(
			long id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(StudentDivisonToStudent.class);
		c.createAlias("schoolAdmin", "sadmin");
		c.add(Restrictions.eq("sadmin.SchoolAdminId", id));
		List<StudentDivisonToStudent> adminList = c.list();
		tx.commit();
		session.close();
		return adminList;
	}

	

}
