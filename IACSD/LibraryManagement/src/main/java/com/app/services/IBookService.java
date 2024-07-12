package com.app.services;

import java.util.List;

import com.app.entities.Book;

public interface IBookService {
	
	Book insert(Book b);
	
	List<Book> retirveAll();
	
	boolean update(Book b);
	
	boolean deleteByTitle(String title);

}
