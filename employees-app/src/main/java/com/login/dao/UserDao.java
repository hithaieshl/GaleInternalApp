package com.login.dao;
import java.sql.SQLException;

/**
 * @author CENTAUR
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
	public boolean isValidUser(String email, String password) throws SQLException;
}

