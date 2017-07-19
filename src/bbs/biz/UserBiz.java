package bbs.biz;

import bbs.dao.impl.UserDAO;
import bbs.entity.User;

public class UserBiz {

	UserDAO userDAO = new UserDAO();

	public User findUserByUserName(String userName) {

		return userDAO.findUserByUserName(userName);
	}

	public User findUserByUserId(int userId) {

		return userDAO.findUserByUserId(userId);
	}

	public boolean addUser(User user) {

		return userDAO.addUser(user);
	}

	public User doLogin(String userName, String userPwd) {
		User user = userDAO.findUserByUserName(userName);
		if (user != null && user.getUserPwd().equals(userPwd)) {
			return user;
		}
		return null;
	}

	public boolean isExistUser(String userName) {
		if (userDAO.findUserByUserName(userName) == null) {
			return false;
		}
		return true;
	}

}
