package com.Univerclassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.Book;
import com.Univerclassroom.model.BookIssue;
import com.Univerclassroom.model.Librarian;
import com.Univerclassroom.model.School;

public class LibrarianDaoImpl implements LibrarianDao  {

	

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addLibrarian(Librarian librarian) throws Exception {
		
		
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(librarian);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
		
		
	}

	@Override
	public boolean login(Librarian librarian) {
		
		   boolean flag=true;
		    try{  	
		    session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Librarian.class);
			c.add(Restrictions.eq("Username", librarian.getUsername()));
			c.add(Restrictions.eq("Password",librarian.getPassword() ));
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

	@Override
	public Librarian getLibrarianByUsername(String username) {
		
		Session session;
		Librarian  librarian = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Librarian.class);
			 criteria.add(Restrictions.eq("Username", username));
	     	 Object result=criteria.uniqueResult();
			 librarian = (Librarian)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return librarian;
	}

	@Override
	public Librarian getLibrarianById(long LibrarianId) throws Exception {
		
		session = sessionFactory.openSession();
		Librarian librarian = (Librarian) session.load(Librarian.class,
				new Long(LibrarianId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return librarian;		

	}

	@Override
	public boolean addBook(Book book) throws Exception {
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(book);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
	}

	
	@Override
	public List<Book> getBookListByTitle(String Title,Long LibrarianId) throws Exception {
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Book.class);
		cr.createAlias("librarian", "lib");
		cr.add(Restrictions.eq("lib.LibrarianId", LibrarianId));
		cr.add(Restrictions.eq("Title", Title));
		cr.add(Restrictions.eq("issued", false));
		List<Book> BookList  = cr.list();
		
		return BookList;
	}

	@Override
	public List<Book> getBookListByLibId(Long LibrarianId) throws Exception {
			
		Session session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria c = session.createCriteria(Book.class);
		c.createAlias("librarian", "lib");
		c.add(Restrictions.eq("lib.LibrarianId", LibrarianId));
		c.add(Restrictions.eq("issued", false));
		List<Book> BookList  = c.list();
		tx.commit();
		session.close();
		return BookList;
		
	}

	@Override
	public Book getBookById(long UniqueIdentifier) throws Exception {
		
		session = sessionFactory.openSession();
		Book book = (Book) session.load(Book.class,
				new Long(UniqueIdentifier));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return book;	
		
	}

	@Override
	public boolean addBookIssue(BookIssue bookIssue) {
		
		boolean flag = false;
		 try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(bookIssue);
				flag = true;
				tx.commit();
				session.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;		
		
		
		
		
	}

}
