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

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentToParent;

@Proxy(lazy=false)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	boolean flag = false;
	
	@Override
	public boolean addOrUpdateStudent(Student student) {
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(student);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
	}
	
	@Override
	public boolean addOrUpdateStudentToParent(StudentToParent stp) {
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(stp);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;	
	}

	@Override
	public Student getStudent(StudentAdmissionDTO sad) {
		Student student = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("StudentFirstName", sad.getStudentFirstName()));
		criteria.add(Restrictions.eq("StudentLastName", sad.getStudentLastName()));
		criteria.add(Restrictions.eq("Nationality", sad.getNationality()));
		criteria.add(Restrictions.eq("DOB", sad.getDob()));
		criteria.add(Restrictions.eq("DOBPlace", sad.getDobPlace()));
		criteria.add(Restrictions.eq("DOBDistrict", sad.getDobDistrict()));
		criteria.add(Restrictions.eq("DOBState", sad.getDobState()));
		criteria.add(Restrictions.eq("BloodGroup", sad.getBloodGroup()));
		Object result=criteria.uniqueResult();
		student = (Student)result;
		tx.commit();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return student;
	}

}