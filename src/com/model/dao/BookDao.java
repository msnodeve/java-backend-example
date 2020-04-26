package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.dto.Book;
import com.model.dto.Books;
import com.model.dto.Publisher;
import com.util.DBUtil;

public class BookDao implements BookDaoInterface {

	@Override
	public List<Publisher> searchAllofPublisher() throws SQLException {
		List<Publisher> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select pno, publisher, address \n");
			sql.append("from publisher;");
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setPno(rs.getInt("pno"));
				publisher.setPublisher(rs.getString("publisher"));
				publisher.setAddress(rs.getString("address"));
				list.add(publisher);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return list;
	}

	@Override
	public void insertBook(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(book);
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into book (isbn, pno, title, author, description, price, date) \n");
			sql.append("values (?, ?, ?, ?, ?, ?, ?)");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book.getIsbn());
			pstmt.setInt(2, book.getPno());
			pstmt.setString(3, book.getTitle());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getDescription());
			pstmt.setInt(6, book.getPrice());
			pstmt.setString(7, book.getDate());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<Books> searchAllBook() throws SQLException {
		List<Books> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select isbn, title, author, description, price, date, publisher, address \n");
			sql.append("from book, publisher \n");
			sql.append("where book.pno = publisher.pno;");
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Books book = new Books();

				book.setIsbn((rs.getString("isbn")));
				book.setTitle((rs.getString("title")));
				book.setAuthor((rs.getString("author")));
				book.setDescription((rs.getString("description")));
				book.setPrice((rs.getInt("price")));
				book.setDate((rs.getString("date")));
				book.setPublisher((rs.getString("publisher")));
				book.setAddress((rs.getString("address")));

				list.add(book);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return list;
	}

	@Override
	public List<Books> searchByTitle(String title) throws SQLException {
		List<Books> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select isbn, title, author, description, price, date, publisher, address \n");
			sql.append("from book, publisher \n");
			sql.append("where book.pno = publisher.pno \n");
			sql.append("and book.title like ?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + title + "%");
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Books book = new Books();

				book.setIsbn((rs.getString("isbn")));
				book.setTitle((rs.getString("title")));
				book.setAuthor((rs.getString("author")));
				book.setDescription((rs.getString("description")));
				book.setPrice((rs.getInt("price")));
				book.setDate((rs.getString("date")));
				book.setPublisher((rs.getString("publisher")));
				book.setAddress((rs.getString("address")));

				list.add(book);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return list;
	}

	@Override
	public List<Books> searchByPublisher(String publisher) throws SQLException {
		List<Books> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select isbn, title, author, description, price, date, publisher, address \n");
			sql.append("from book, publisher \n");
			sql.append("where book.pno = publisher.pno \n");
			sql.append("and publisher.publisher like ?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + publisher + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Books book = new Books();

				book.setIsbn((rs.getString("isbn")));
				book.setTitle((rs.getString("title")));
				book.setAuthor((rs.getString("author")));
				book.setDescription((rs.getString("description")));
				book.setPrice((rs.getInt("price")));
				book.setDate((rs.getString("date")));
				book.setPublisher((rs.getString("publisher")));
				book.setAddress((rs.getString("address")));

				list.add(book);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return list;
	}

	@Override
	public List<Books> searchByPrice(int price) throws SQLException {
		List<Books> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select isbn, title, author, description, price, date, publisher, address \n");
			sql.append("from book, publisher \n");
			sql.append("where book.pno = publisher.pno \n");
			sql.append("and book.price <= ?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, price);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Books book = new Books();

				book.setIsbn((rs.getString("isbn")));
				book.setTitle((rs.getString("title")));
				book.setAuthor((rs.getString("author")));
				book.setDescription((rs.getString("description")));
				book.setPrice((rs.getInt("price")));
				book.setDate((rs.getString("date")));
				book.setPublisher((rs.getString("publisher")));
				book.setAddress((rs.getString("address")));

				list.add(book);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return list;
	}

	@Override
	public void deleteBook(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from book \n");
			sql.append("where isbn = ?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public Books searchByBook(String isbn) throws SQLException {
		Books book = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select isbn, title, author, description, price, date, publisher, address \n");
			sql.append("from book, publisher \n");
			sql.append("where book.pno = publisher.pno \n");
			sql.append("and book.isbn = ?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Books();
				book.setIsbn((rs.getString("isbn")));
				book.setTitle((rs.getString("title")));
				book.setAuthor((rs.getString("author")));
				book.setDescription((rs.getString("description")));
				book.setPrice((rs.getInt("price")));
				book.setDate((rs.getString("date")));
				book.setPublisher((rs.getString("publisher")));
				book.setAddress((rs.getString("address")));
				return book;
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return book;
	}
}
