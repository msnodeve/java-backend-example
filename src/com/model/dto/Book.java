package com.model.dto;

public class Book {
	private String isbn;
	private int pno;
	private String title;
	private String author;
	private String description;
	private int price;
	private String date;
	
	public Book(String isbn, int pno, String title, String author, String description, int price, String date) {
		super();
		this.isbn = isbn;
		this.pno = pno;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.date = date;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", pno=" + pno + ", title=" + title + ", author=" + author + ", description="
				+ description + ", price=" + price + ", date=" + date + "]";
	}
	
}
