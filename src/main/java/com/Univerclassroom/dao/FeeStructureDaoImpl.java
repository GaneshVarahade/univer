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

import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.FeeStructure;

@Proxy(lazy=false)

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class FeeStructureDaoImpl implements FeeStructureDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addFeeStructure(FeeStructure fee) throws Exception {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(fee);
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
	public boolean checkClassUnique(FeeStructure fee) {
		boolean flag = false;
		List<FeeStructure> list = new ArrayList<FeeStructure>();
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
		String hql = "from FeeStructure where ClassName =:classname";
		Query query = session.createQuery(hql);
		query.setString("classname", fee.getClassName());
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

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public FeeStructure getFeeStructurebyClassname(String classname) {
		Session session;
		FeeStructure  fee = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(FeeStructure.class);
			 criteria.add(Restrictions.eq("ClassName", classname));
			 Object result=criteria.uniqueResult();
			 fee = (FeeStructure)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return fee;

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<FeeStructure> getFeeStructureList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<FeeStructure> list = session.createCriteria(FeeStructure.class)
.list();
		tx.commit();
		session.close();
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public FeeStructure getFeeStructureById(long id) throws Exception {
		session = sessionFactory.openSession();
		FeeStructure admin = (FeeStructure) session.load(FeeStructure.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return admin;
	}

	@Override
	public boolean deleteFeeStructure(long iD) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(FeeStructure.class, iD);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

}
