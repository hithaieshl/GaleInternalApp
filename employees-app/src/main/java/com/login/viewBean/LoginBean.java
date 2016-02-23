/*
 * 
 */
package com.login.viewBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginBean.
 */
public class LoginBean
{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginBean.class);
	
	/** The pass. */
	String email,pass;

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		LOGGER.info("Getting email object");
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		LOGGER.info("Setting email object");
		this.email = email;
	}

	/**
	 * Gets the pass.
	 *
	 * @return the pass
	 */
	public String getPass() {
		LOGGER.info("Getting pass object");
		return pass;
	}

	/**
	 * Sets the pass.
	 *
	 * @param pass the new pass
	 */
	public void setPass(String pass) {
		LOGGER.info("Setting pass object");
		this.pass = pass;
	}
	
	/**
	 * Instantiates a new login bean.
	 */
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", pass=" + pass + "]";
	}
	
	
	/**
	 * Validate.
	 *
	 * @return the string
	 */
	public String validate()
	{
		LOGGER.info("Validating input fields email and password");
		StringBuilder sb = new StringBuilder();
		if(email==null || email.trim().equals(""))
			sb.append("Email is empty. It should not be!<br/>");
		if(pass ==null || pass.trim().equals(""))
			sb.append("Pass is mandatory. It should be entered!");
		
		String msg = sb.toString();
		
		if(msg.equals(""))
			return "SUCCESS";
		else
			return msg;
	}
}