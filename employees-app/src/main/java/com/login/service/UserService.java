package com.login.service;

import java.sql.SQLException;

/**
 * @author CENTAUR
 *
 */
public interface UserService
{
	public boolean isValidUser(String email, String password) throws SQLException;
}
