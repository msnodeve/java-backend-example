package com.model.dao;

import java.sql.SQLException;

import com.model.dto.User;

public interface UserDaoInterface {
	public void signIn(User user) throws SQLException;
	
	public void login(String id, String pw) throws SQLException;
	
	public User getUser(String id) throws SQLException;
	
	public void updateUser(User user) throws SQLException;
}
