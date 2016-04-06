package com.Univerclassroom.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.Education;
import com.Univerclassroom.model.Experience;
import com.Univerclassroom.model.Parent;
import com.Univerclassroom.model.Teacher;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class TeacherDaoImpl implements TeacherDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean TeacherLogin(TeacherDTO tDTO) {
		 boolean flag=true;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Teacher.class);
			c.add(Restrictions.eq("teacherUsername", tDTO.getTeacherUsername()));
			c.add(Restrictions.eq("teacherPassword", tDTO.getTeacherPassword()));
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
	public Teacher getTeacherByUsername(String username) {
		Session session;
		Teacher  teacher = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Teacher.class);
			 criteria.add(Restrictions.eq("teacherUsername", username));
			 Object result=criteria.uniqueResult();
			 teacher = (Teacher)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return teacher;
	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Teacher getTeacherById(long teacherId) throws Exception {
		session = sessionFactory.openSession();
		Teacher teacher = (Teacher) session.load(Teacher.class,
				new Long(teacherId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return teacher;	
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateTeacherField(TeacherDTO dto, Teacher t) {
		if(dto.getGender() != null && !dto.getGender().isEmpty())
		t.setGender(dto.getGender());
		if(dto.getEmailId() != null && !dto.getEmailId().isEmpty())
		t.setEmailId(dto.getEmailId());
		if(dto.getMobileNo() != null)
		t.setMobileNo(dto.getMobileNo());
		if(dto.getAddress() != null && !dto.getAddress().isEmpty())
		t.setAddress(dto.getAddress());
		if(dto.getSubjectProficiency() != null && !dto.getSubjectProficiency().isEmpty())
		t.setSubjectProficiency(dto.getSubjectProficiency());
		if(dto.getMaritalstatus() != null && !dto.getMaritalstatus().isEmpty())
		t.setMaritalstatus(dto.getMaritalstatus());
		if(dto.getCertification() != null && !dto.getCertification().isEmpty())
		t.setCertification(dto.getCertification());
		if(dto.getExperience() != null && !dto.getExperience().isEmpty()){
		Set<Experience> exp = dto.getExperience();
		Set<Experience> expFromTeacher = t.getExperience();
		for (Experience experience : exp) {
			expFromTeacher.add(experience);
		}
		t.setExperience(expFromTeacher);
		}
		if(dto.getEducation() != null && !dto.getEducation().isEmpty()){
		Set<Education> edu = dto.getEducation();
		Set<Education> eduFromTeacher = t.getEducation();
		
		for (Education education : edu) {
			eduFromTeacher.add(education);
		}
		t.setEducation(eduFromTeacher);
		}
		if(dto.getTeacherPassword() != null && !dto.getTeacherPassword().isEmpty())
			t.setTeacherPassword(dto.getTeacherPassword()); 
		if(dto.getTeacherUsername() != null && !dto.getTeacherUsername().isEmpty())
			t.setTeacherPassword(dto.getTeacherUsername()); 
	}

	@Override
	public boolean checkUsername(String username) {
		boolean flag=false;
		Teacher teacher = null;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Teacher.class);
			c.add(Restrictions.eq("teacherUsername", username));
			Object o = c.uniqueResult();
			teacher = (Teacher)o;
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
	public List<Teacher> getTeacherListById(long id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Teacher.class);
		c.createAlias("schoolAdmin", "sadmin");
		c.add(Restrictions.eq("sadmin.SchoolAdminId", id));
		List<Teacher> adminList = c.list();
		for (Teacher teacher : adminList) {
			System.out.println(teacher.getTeacherFirstName());
		}
		tx.commit();
		session.close();
		return adminList;
	}

	@Override
	public boolean deleteTeacher(long id) {
		session = sessionFactory.openSession();
		Object o = session.load(Teacher.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

}
