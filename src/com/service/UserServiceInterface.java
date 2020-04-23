package com.service;

import com.model.dto.User;

public interface UserServiceInterface {
	public void signIn(User user) throws Exception;
	
	public void login(String id, String pw) throws Exception;
	
	public User getUser(String id) throws Exception;
	
	public void updateUser(User user) throws Exception;
}
