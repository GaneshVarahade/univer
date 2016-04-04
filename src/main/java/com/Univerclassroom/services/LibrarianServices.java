package com.Univerclassroom.services;

import com.Univerclassroom.model.Book;
import com.Univerclassroom.model.Librarian;
import com.Univerclassroom.model.SchoolAdmin;

public interface LibrarianServices {

    public boolean addLibrarian(Librarian librarian) throws Exception;

public Librarian getLibrarianByUsername(String username);
	public boolean login(Librarian librarian);
	public Librarian getLibrarianById(long LibrarianId) throws Exception;
	public boolean addBook(Book book) throws Exception;
	
}
