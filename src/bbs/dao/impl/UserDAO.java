package bbs.dao.impl;

import java.sql.Timestamp;

import org.hibernate.*;
import org.hibernate.criterion.*;

import bbs.dao.IBaseDAO;
import bbs.dao.IUserDAO;
import bbs.entity.User;

public class UserDAO extends BaseHibernateDAO implements IUserDAO {
	IBaseDAO baseDAO = new BaseDAO();

	public User findUserByUserId(int userId) {
		return (User) super.findById(User.class, userId);
	}

	public User findUserByUserName(String userName) {
		Session session = super.getSession();
		User user = new User();
		user.setUserName(userName);
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Example.create(user));
		return (User)criteria.uniqueResult();//返回一个对象
	}

	public boolean addUser(User user) {
		user.setRegTime(new Timestamp(System.currentTimeMillis()));
		return super.add(user);
	}


}
