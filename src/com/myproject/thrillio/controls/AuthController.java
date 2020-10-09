package com.myproject.thrillio.controls;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myproject.thrillio.manager.UserManager;

/**
 * Servlet implementation class AuthController
 */
@WebServlet(urlPatterns= {"/auth","/auth/logout"})
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("her in do get of ac");
		System.out.println(request.getServletPath());
		if(!request.getServletPath().contains("logout")) {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			long userId=UserManager.getInstance().authenticate(email,password);
			if(userId!=-1)
		{
			HttpSession session=request.getSession();
			session.setAttribute("userId",userId);
			request.getRequestDispatcher("bookmark/mybooks").forward(request, response);
			
		}
			else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		else {
			request.getSession().invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("her in do post of ac");
		doGet(request, response);
	}

}
