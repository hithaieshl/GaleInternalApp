package com.login.service.impl;

import java.sql.SQLException;

import com.login.dao.UserDao;
import com.login.service.UserService;

public class UserServiceImpl implements UserService
{

	private UserDao userDao;

	public UserDao getUserDao()
	{
		return this.userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public boolean isValidUser(String email, String password) throws SQLException
	{
		return userDao.isValidUser(email, password);
	}

}
