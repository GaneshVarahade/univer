package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentDivision;


@Proxy(lazy=false)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class StudentDivisionDaoImpl implements StudentDivisionDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addStudentDivision(StudentDivision studentClass)
			throws Exception {
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
	public boolean deleteStudentDivision(long studentClassId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StudentDivision> getStudentDivisionListByStudentClassId(
			long studentClassId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkStudentDivisionUnique(StudentDivision studClass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudentDivision getStudentDivisionById(long id) throws Exception {
		session = sessionFactory.openSession();
		StudentDivision studentDivision = (StudentDivision) session.load(StudentDivision.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return studentDivision;	
	}

}
