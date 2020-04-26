package com.service;

import java.util.List;

import com.model.dao.BookDao;
import com.model.dao.BookDaoInterface;
import com.model.dto.Book;
import com.model.dto.Books;
import com.model.dto.Publisher;

public class BookService implements BookServiceInterface {

	private BookDaoInterface bookDao;

	public BookService() {
		bookDao = new BookDao();
	}

	@Override
	public List<Publisher> searchAllofPublisher() throws Exception {
		return bookDao.searchAllofPublisher();
	}

	@Override
	public void insertBook(Book book) throws Exception {
		bookDao.insertBook(book);
	}

	@Override
	public List<Books> searchAllBook() throws Exception {
		return bookDao.searchAllBook();
	}

	@Override
	public List<Books> searchByTitle(String title) throws Exception {
		if (title == null)
			throw new Exception();
		return bookDao.searchByTitle(title);
	}

	@Override
	public List<Books> searchByPublisher(String publisher) throws Exception {
		if (publisher == null)
			throw new Exception();
		return bookDao.searchByPublisher(publisher);
	}

	@Override
	public List<Books> searchByPrice(int price) throws Exception {
		return bookDao.searchByPrice(price);
	}

	@Override
	public void deleteBook(String isbn) throws Exception {
		if (isbn == null)
			throw new Exception();
		bookDao.deleteBook(isbn);
	}

	@Override
	public Books searchByBook(String isbn) throws Exception {
		if (isbn == null)
			throw new Exception();
		return bookDao.searchByBook(isbn);
	}
}
