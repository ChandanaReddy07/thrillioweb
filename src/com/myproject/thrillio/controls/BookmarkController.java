package com.myproject.thrillio.controls;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.thrillio.constants.KidFriendlyStatus;
import com.myproject.thrillio.entities.BookMark;
import com.myproject.thrillio.entities.User;
import com.myproject.thrillio.manager.BookmarkManager;
import com.myproject.thrillio.manager.UserManager;

/**
 * Servlet implementation class MyBooks
 */
@WebServlet(urlPatterns = { "/bookmark", "/bookmark/save", "/bookmark/mybooks" })
public class BookmarkController extends HttpServlet {

	/*
	 * private static BookmarkController instance=new BookmarkController(); private
	 * BookmarkController() {} public static BookmarkController getInstance() {
	 * return instance; }
	 */
	public BookmarkController() {
		// TODO Auto-generated constructor stub
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("her in do get of bc");
		
		RequestDispatcher dispatcher = null;
		
		System.out.println("servlet path" + request.getServletPath());
		if(request.getSession().getAttribute("userId")!=null) {
			
			System.out.println(request.getSession().getAttribute("userId")+" user ID");
			Long userId=(long)request.getSession().getAttribute("userId");
			System.out.println(userId+" user ID2");
			if (request.getServletPath().contains("save")) {
				// save
				dispatcher = request.getRequestDispatcher("/mybooks.jsp");
				
				String bid=request.getParameter("bid");
				User user = UserManager.getInstance().getUser(userId);
				BookMark bookmark=BookmarkManager.getInstance().getBook(Long.parseLong(bid));
				
				BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
				
				Collection<BookMark> list = BookmarkManager.getInstance().getBooks(true, userId);
				
				request.setAttribute("books", list);
				
			} else if (request.getServletPath().contains("mybooks")) {
				// mybooks
				dispatcher = request.getRequestDispatcher("/mybooks.jsp");
				Collection<BookMark> list = BookmarkManager.getInstance().getBooks(true,userId);
				request.setAttribute("books", list);
				
			} else{
				dispatcher = request.getRequestDispatcher("/browse.jsp");
				Collection<BookMark> list = BookmarkManager.getInstance().getBooks(false, userId);
				request.setAttribute("books", list);
				System.out.println(list);
//			  browse jsp kaha hai
				// 2. Forwarding to View
				}
			
		}else {
			dispatcher = request.getRequestDispatcher("/login.jsp");
		}
		
		dispatcher.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("her in do post of bc");
		doGet(request, response);
	}

	public void saveUserBookmark(User user, BookMark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, BookMark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

	}

	public void share(User user, BookMark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);

	}

}
