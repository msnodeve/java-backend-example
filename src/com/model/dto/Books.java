package com.model.dto;

/**
 * @author msno2
 *
 */
public class Books {
	private String isbn;
	private String title;
	private String author;
	private String description;
	private int price;
	private String date;
	private String publisher;
	private String address;
	
	public Books() {
		
	}
	
	public Books(String isbn, String title, String author, String description, int price, String date, String publisher,
			String address) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.date = date;
		this.publisher = publisher;
		this.address = address;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Books [isbn=" + isbn + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", date=" + date + ", publisher=" + publisher + ", address=" + address + "]";
	}
}
