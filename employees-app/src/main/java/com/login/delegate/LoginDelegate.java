/*
 * 
 */
package com.login.delegate;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.login.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginDelegate.
 */
public class LoginDelegate{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDelegate.class);
	
	/** The user service. */
	private UserService userService;

	/**
	 * Gets the user service.
	 *
	 * @return the user service
	 */
	public UserService getUserService()
	{
		LOGGER.info("Getting UserService object");
		return this.userService;
	}

	/**
	 * Sets the user service.
	 *
	 * @param userService the new user service
	 */
	public void setUserService(UserService userService)
	{
		LOGGER.info("Setting UserService object");
		this.userService = userService;
	}

	/**
	 * Checks if is valid user.
	 *
	 * @param email the email
	 * @param password the password
	 * @return true, if is valid user
	 * @throws SQLException the SQL exception
	 */
	public boolean isValidUser(String email, String password) throws SQLException
	{
	    return userService.isValidUser(email, password);
	}
}
