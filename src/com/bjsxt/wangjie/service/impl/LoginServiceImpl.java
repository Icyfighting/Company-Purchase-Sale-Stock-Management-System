/**
 * @Title:LoginServiceImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.service.impl;

import com.bjsxt.pojo.User;
import com.bjsxt.wangjie.dao.UserDao;
import com.bjsxt.wangjie.dao.impl.UserDaoImpl;
import com.bjsxt.wangjie.service.LoginService;

/**
 * @Title:LoginServiceImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public class LoginServiceImpl implements LoginService {

	private UserDao userDao = new UserDaoImpl();
	@Override
	public User login(String uname, String upwd) {
		// TODO Auto-generated method stub
		User user = userDao.login(uname, upwd);
		if (user == null) {
			return null;
		}
		return user;
	}

}
