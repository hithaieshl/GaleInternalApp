/*
 * 
 */
package com.login.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.login.dao.UserDao;


// TODO: Auto-generated Javadoc
/**
 * The Class UserDaoImpl.
 */
public class UserDaoImpl implements UserDao
{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	/** The data source. */
	DataSource dataSource ;

	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	public DataSource getDataSource()
	{
		LOGGER.info("Getting DataSource object");
		return this.dataSource;
	}

	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource)
	{
		LOGGER.info("Setting DataSource object");
		this.dataSource = dataSource;
	}

	/* (non-Javadoc)
	 * @see com.login.dao.UserDao#isValidUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValidUser(String email, String password) throws SQLException
	{
		LOGGER.info("Querying database");
		String query = "Select count(1) from person where email = ? and password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if(resultSet.next())
		    return (resultSet.getInt(1) > 0);
        else
           return false;
       }

}