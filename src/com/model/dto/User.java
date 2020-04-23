package com.model.dto;

public class User {
	private String id;
	private String pw;
	private String email;
	private String address;
	private String tel;
	
	public User() {
		
	}

	public User(String id, String pw, String email, String address, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.address = address;
		this.tel = tel;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", email=" + email + ", address=" + address + ", tel=" + tel + "]";
	}
}
