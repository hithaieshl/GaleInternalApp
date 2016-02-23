

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String lemail="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        System.out.println("in no-arg constr of CS");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("in doGet() of CS");
//		process(request,response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost() of CS");
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in process() of CS");
		//embed controlling logic here!
		
		/*
		 * if req is coming by user clicking Click to Register,
		 * forward to Register.jsp
		 * if req is coming for /openLoginView.do then forward to
		 * Login.jsp
		 */
		Model model = new Model();
		String uri = request.getRequestURI();
		System.out.println("uri = "+uri);
		RequestDispatcher rd = null;
		
		
		
		/*if(uri.contains("/logout.do"))
		{
			//invalidate the session
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
				session.removeAttribute("user");
				session.invalidate();
			}
			rd = request.getRequestDispatcher("Success.jsp");
			request.setAttribute("msg","You have logged out successfully! Who are you? Click <a href='HomePage.jsp'>Click to go back to HomePage</a>");
			rd.forward(request, response);
		}*/
		
		
		/*if(uri.contains("/openLoginView.do"))
		{
			//forward to Login.jsp
			System.out.println("in /openloginview.do");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}*/
		
		if(uri.contains("/login.do"))
		{
			System.out.println("in uri.contains(/login.do)");
			
			
			String email= (String)request.getParameter("email");
			String password= (String)request.getParameter("password");
			System.out.println("Username = " +email);
			
			String result = model.authenticate(email,password);
			if(result.equals(Constants.SUCCESS))
			{
				//login successful!
				//create a session! for the user and store data we need to remember!
				HttpSession session = request.getSession(true);
				session.setAttribute("user", email);
				
				
				rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
				return;
			}
			else
			{
				//login failure!
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
		
			}
		}
		
		
	}
	
}





