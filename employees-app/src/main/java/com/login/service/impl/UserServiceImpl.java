/*
 * 
 */
package com.login.service.impl;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.login.dao.UserDao;
import com.login.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
public class UserServiceImpl implements UserService
{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/** The user dao. */
	private UserDao userDao;

	/**
	 * Gets the user dao.
	 *
	 * @return the user dao
	 */
	public UserDao getUserDao()
	{
		LOGGER.info("Getting UserDao object");
		return this.userDao;
	}

	/**
	 * Sets the user dao.
	 *
	 * @param userDao the new user dao
	 */
	public void setUserDao(UserDao userDao)
	{
		LOGGER.info("Setting UserDao object");
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.login.service.UserService#isValidUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValidUser(String email, String password) throws SQLException
	{
		return userDao.isValidUser(email, password);
	}

}
