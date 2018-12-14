/**
 * @Title:UserDaoImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:Your Company
 *
 * @author Your Name
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao.impl;

import com.bjsxt.pojo.User;
import com.bjsxt.wangjie.dao.UserDao;

/**
 * @Title:UserDaoImpl
 * @Description:TODO
 * @Company:Your Company
 * 
 * @author wang jie
 * @data 2018年3月14日
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(String uname, String upwd) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where name=? and pwd=?";
		return queryOne(User.class, sql, uname, upwd);
	}

}
