package com.model.dto;

public class Publisher {
	private int pno;
	private String publisher;
	private String address;
	
	public Publisher() {
		
	}

	public Publisher(int pno, String publisher, String address) {
		super();
		this.pno = pno;
		this.publisher = publisher;
		this.address = address;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
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
		return "Publisher [pno=" + pno + ", publisher=" + publisher + ", address=" + address + "]";
	}
}
