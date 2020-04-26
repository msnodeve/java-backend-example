package com.service;

import java.util.List;

import com.model.dto.Book;
import com.model.dto.Books;
import com.model.dto.Publisher;

public interface BookServiceInterface {
	public List<Publisher> searchAllofPublisher() throws Exception;

	public void insertBook(Book book) throws Exception;

	public List<Books> searchAllBook() throws Exception;

	public List<Books> searchByTitle(String title) throws Exception;

	public List<Books> searchByPublisher(String publisher) throws Exception;

	public List<Books> searchByPrice(int price) throws Exception;

	public void deleteBook(String isbn) throws Exception;
	
	public Books searchByBook(String isbn) throws Exception;
}
