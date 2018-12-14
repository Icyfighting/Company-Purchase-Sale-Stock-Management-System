package com.bjsxt.zhang.service;

import java.util.List;
import java.util.Map;

import com.bjsxt.pojo.User;

public interface UserService {

	Map<String, Object> login(String name, String pwd);

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 */
	boolean updPwd(int id, String opwd, String npwd);

	/**
	 * 通过角色编号查询用户
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
