package com.Univerclassroom.services;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Univerclassroom.dao.LibrarianDao;
import com.Univerclassroom.dao.SchoolAdminDao;
import com.Univerclassroom.model.Book;
import com.Univerclassroom.model.Librarian;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("Librarianservices")
public class LibrarianServicesImpl implements LibrarianServices {

	

	@Autowired
	LibrarianDao librarianDao;

	@Override
	public boolean addLibrarian(Librarian librarian) throws Exception {
		librarianDao.addLibrarian(librarian);
		return false;
	}

	@Override
	public boolean login(Librarian librarian) {
		return librarianDao.login(librarian);
	}

	@Override
	public Librarian getLibrarianByUsername(String username) {	
		return librarianDao.getLibrarianByUsername(username);
	}

	@Override
	public Librarian getLibrarianById(long LibrarianId) throws Exception {
		
		return librarianDao.getLibrarianById(LibrarianId) ;
	}

	@Override
	public boolean addBook(Book book) throws Exception {
		
		return librarianDao.addBook(book)  ;
	}

}
