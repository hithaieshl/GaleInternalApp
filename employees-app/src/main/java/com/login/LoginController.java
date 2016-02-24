/*
 * 
 */
package com.login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.login.delegate.LoginDelegate;
import com.login.viewBean.LoginBean;


// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController
{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/** The login delegate. */
	@Autowired
	private LoginDelegate loginDelegate;

	/**
	 * Display login.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
	{
		LOGGER.info("LoginController displayLogin()");
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}
	
	/**
	 * Execute login.
	 *
	 * @param request the request
	 * @param response the response
	 * @param loginBean the login bean
	 * @return the model and view
	 */
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
	{
		LOGGER.info("LoginController executeLogin()");
		ModelAndView model= null;
		try
		{
			boolean isValidUser = loginDelegate.isValidUser(loginBean.getEmail(), loginBean.getPass());
			if(isValidUser)
			{
				LOGGER.info("User login successfull");
				request.setAttribute("loggedInUser", loginBean.getEmail());
				model = new ModelAndView("home");
			}
			else
			{
				LOGGER.info("Someone's trying to hack .....ALERT ALERT!!!!!");
				model = new ModelAndView("login");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		LOGGER.info("Returning ModelAndView object");
		return model;
	}
}
