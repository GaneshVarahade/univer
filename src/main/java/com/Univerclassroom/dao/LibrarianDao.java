package com.Univerclassroom.dao;

import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.Book;
import com.Univerclassroom.model.Librarian;
import com.Univerclassroom.model.SchoolAdmin;

public interface LibrarianDao {
	public boolean addLibrarian(Librarian librarian) throws Exception;
	public boolean login(Librarian librarian);
	public Librarian getLibrarianByUsername(String username);
	public Librarian getLibrarianById(long LibrarianId) throws Exception;
	public boolean addBook(Book book) throws Exception;
}
