package com.bjsxt.zhang.dao;

import java.util.List;

import com.bjsxt.pojo.User;

public interface UserDao {

	/**
	 * 用户登录操作
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name, String pwd);

	public User selByIdPwd(int id, String pwd);

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 */
	boolean updPwd(int id, String pwd);

	/**
	 * 根据角色编号查询用户信息
	 * 
	 * @param roleId
	 * @return
	 */
	List<User> selById(int roleId);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	boolean insUser(User user);

}
