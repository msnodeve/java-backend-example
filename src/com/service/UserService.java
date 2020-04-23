package com.service;

import com.model.dao.UserDao;
import com.model.dao.UserDaoInterface;
import com.model.dto.User;

public class UserService implements UserServiceInterface {

	private UserDaoInterface userDao;

	public UserService() {
		userDao = new UserDao();
	}

	@Override
	public void signIn(User user) throws Exception {
		if(getUser(user.getId()) != null) {
			throw new Exception();
		}
		userDao.signIn(user);
	}

	@Override
	public User login(String id, String pw) throws Exception {
		if(id == null || pw == null)
			throw new Exception();
		return userDao.login(id, pw);
	}

	@Override
	public User getUser(String id) throws Exception {
		if(id == null)
			throw new Exception();
		return userDao.getUser(id);
	}

	@Override
	public void updateUser(User user) throws Exception {

	}
}
