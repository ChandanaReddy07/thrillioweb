package com.myproject.thrillio.manager;

import java.util.List;

import com.myproject.thrillio.constants.Gender;
import com.myproject.thrillio.constants.UserType;
import com.myproject.thrillio.dao.UserDao;
import com.myproject.thrillio.entities.BookMark;
import com.myproject.thrillio.entities.User;
import com.myproject.thrillio.util.StringUtil;

public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao=new UserDao();

	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, Gender gender,
			UserType userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);

		return user;

	}
	
	/*public  List<User> getUsers() {
		return dao.getUsers();
	}*/

	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return dao.getUser(userId);
	}

	public long authenticate(String email, String password) {
		// TODO Auto-generated method stub
		return dao. authenticate( email,StringUtil.encodePassword(password)) ;
	}

	

}
