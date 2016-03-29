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
		criteria.add(Restrictions.eq("FatherFirstName", sad.getFatherFirstName()));
		criteria.add(Restrictions.eq("FatherLastName", sad.getFatherLastName()));
		criteria.add(Restrictions.eq("MotherFirstName", sad.getMotherFirstName()));
		criteria.add(Restrictions.eq("MotherLastName", sad.getMotherLastName()));
		if(sad.getGuardianFirstName() != null)
		criteria.add(Restrictions.eq("GuardianFirstName", sad.getGuardianFirstName()));
		if(sad.getGuardianLastName() != null)
		criteria.add(Restrictions.eq("GuardianLastName", sad.getGuardianLastName()));
		criteria.add(Restrictions.eq("FatherOccupation", sad.getFatherOccupation()));
		criteria.add(Restrictions.eq("MotherOccupation", sad.getMotherOccupation()));
		criteria.add(Restrictions.eq("FatherAnnualIncome", sad.getFatherAnnualIncome()));
		Object result=criteria.uniqueResult();
		parent = (Parent)result;
		tx.commit();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return parent;

	}

}