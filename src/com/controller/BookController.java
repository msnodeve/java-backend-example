package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dto.Book;
import com.model.dto.Books;
import com.model.dto.Publisher;
import com.service.BookService;
import com.service.BookServiceInterface;

@WebServlet("/book.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookServiceInterface bookService;

	@Override
	public void init() throws ServletException {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "/index.jsp";

		switch (act) {
		case "mvinsertbook":
			getPublisher(request, response);
			break;
		case "insertbook":
			insertBook(request, response);
			break;
		case "booklist":
			searchAllBook(request, response);
			break;
		case "searchitem":
			searchByItem(request, response);
			break;
		case "view":
			searchBook(request, response);
			break;
		}
	}

	private void searchByItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		List<Books> list = new ArrayList<>();
		try {
			String option = request.getParameter("searchoption");
			switch(option) {
			case "all":
				list = bookService.searchAllBook();
				break;
			case "title":
				String title = request.getParameter("searchitem");
				list = bookService.searchByTitle(title);
				break;
			case "publisher":
				String publisher = request.getParameter("searchitem");
				list = bookService.searchByPublisher(publisher);
				break;
			case "price":
				int price = Integer.parseInt(request.getParameter("searchitem"));
				list = bookService.searchByPrice(price);
				break;
			}
			request.setAttribute("books", list);
			path = "/book/list_book.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "도서 목록 가져오는 도 중 에러 발생");
			path = "/error/error.jsp";
		}
		forward(request, response, path);
	}
	
	private void searchBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		try {
			String isbn = request.getParameter("book");
			Books book = bookService.searchByBook(isbn);
			request.setAttribute("book", book);
			path = "/book/view_book.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "도서 정보를 가져오는 도 중 에러 발생");
			path = "/error/error.jsp";
		}
		forward(request, response, path);
	}
	
	private void searchAllBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		try {
			List<Books> list = bookService.searchAllBook();
			request.setAttribute("books", list);
			path = "/book/list_book.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "도서 목록 가져오는 도 중 에러 발생");
			path = "/error/error.jsp";
		}
		forward(request, response, path);
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";

		String isbn = request.getParameter("isbn1") + "-" + request.getParameter("isbn2") + "-"
				+ request.getParameter("isbn3");
		int publisher = Integer.parseInt(request.getParameter("publisher"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		String date = request.getParameter("date");
		
		Book book = new Book(isbn, publisher, title, author, description, price, date);
		
		try {
			bookService.insertBook(book);
			path = "/book/result_book.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "도서 입력 중 에러 발생");
			path = "/error/error.jsp";
		}
		forward(request, response, path);
	}

	private void getPublisher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		try {
			List<Publisher> list = bookService.searchAllofPublisher();
			request.setAttribute("publishers", list);
			path = "/book/insert_book.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "도서 입력 페이지 이동 중 에러 발생");
			path = "/error/error.jsp";
		}
		forward(request, response, path);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void redirect(HttpServletResponse response, String path, String root) throws IOException {
		response.sendRedirect(root + path);
	}
}
