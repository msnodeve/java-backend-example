package com.service;

import com.model.dao.UserDao;
import com.model.dao.UserDaoInterface;
import com.model.dto.User;

public class UserService implements UserServiceInterface{
	
	private UserDaoInterface UserDao;
	
	public UserService() {
		UserDao = new UserDao();
	}
	
	@Override
	public void signIn(User user) throws Exception {
		UserDao.signIn(user);
	}

	@Override
	public void login(String id, String pw) throws Exception {
		
	}

	@Override
	public User getUser(String id) throws Exception {
		return null;
	}

	@Override
	public void updateUser(User user) throws Exception {
		
	}
}
