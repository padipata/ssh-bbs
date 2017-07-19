package bbs.dao;

import bbs.entity.User;

public interface IUserDAO {

	public boolean addUser(User user); // 用户注册

	public User findUserByUserId(int userId); // 根据userid查找用户

	public User findUserByUserName(String userName); // 用户登录

}
