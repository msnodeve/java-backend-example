package com.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.dto.Book;
import com.model.dto.Books;
import com.model.dto.Publisher;

public interface BookDaoInterface {
	public List<Publisher> searchAllofPublisher() throws SQLException;

	public void insertBook(Book book) throws SQLException;

	public List<Books> searchAllBook() throws SQLException;

	public List<Books> searchByTitle(String title) throws SQLException;

	public List<Books> searchByPublisher(String publisher) throws SQLException;

	public List<Books> searchByPrice(int price) throws SQLException;

	public void deleteBook(String isbn) throws SQLException;
	
	public Books searchByBook(String isbn) throws SQLException;
}
