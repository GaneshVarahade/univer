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

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.Book;
import com.Univerclassroom.model.FeeStructure;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentToParent;
import com.Univerclassroom.model.Teacher;

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
		criteria.add(Restrictions.eq("StudentEmailId", sad.getStudentEmailId()));
		Object result=criteria.uniqueResult();
		student = (Student)result;
		tx.commit();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean checkStudentUnique(Student student) {
		boolean flag = false;
		List<Student> list = new ArrayList<Student>();
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
		String hql = "from Student where StudentEmailId =:studentEmailId";
		Query query = session.createQuery(hql);
		query.setString("studentEmailId", student.getStudentEmailId());
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
	public boolean checkRollNo(String rollNo) {
		boolean flag=false;
		 Student student = null;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Student.class);
			c.add(Restrictions.eq("RollNo", rollNo));
			Object o = c.uniqueResult();
			student = (Student)o;
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
	public boolean checkUsername(String username) {
		 boolean flag=false;
		 Student student = null;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Student.class);
			c.add(Restrictions.eq("StudentUsername", username));
			Object o = c.uniqueResult();
			student = (Student)o;
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
	public List<Student> getStudentListBySchoolAdminId(long scoolAdminId)
			throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Student.class);
		c.createAlias("Schooladmin", "sadmin");
		c.add(Restrictions.eq("sadmin.SchoolAdminId", scoolAdminId));
		List<Student> studentList = c.list();
		tx.commit();
		session.close();
		return studentList;
	}

	@Override
	public Student getStudentById(long StudentId) throws Exception {
		
		session = sessionFactory.openSession();
		Student student = (Student) session.load(Student.class,
				new Long(StudentId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return student;	
		
	}


}