package com.Univerclassroom.dao;

import com.Univerclassroom.model.Librarian;
import com.Univerclassroom.model.SchoolAdmin;

public interface LibrarianDao {
	public boolean addLibrarian(Librarian librarian) throws Exception;
	
	public boolean login(Librarian Schooladmin);
	
	
}
