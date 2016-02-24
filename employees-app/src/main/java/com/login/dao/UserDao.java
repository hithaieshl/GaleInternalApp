/*
 * 
 */
package com.login.dao;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDao.
 */
public interface UserDao
{
	
	/**
	 * Checks if is valid user.
	 *
	 * @param email the email
	 * @param password the password
	 * @return true, if is valid user
	 * @throws SQLException the SQL exception
	 */
	public boolean isValidUser(String email, String password) throws SQLException;
}

