package com.login.delegate;

import java.sql.SQLException;

import com.login.service.UserService;

public class LoginDelegate
{
	private UserService userService;

	public UserService getUserService()
	{
		return this.userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public boolean isValidUser(String email, String password) throws SQLException
	{
	    return userService.isValidUser(email, password);
	}
}
