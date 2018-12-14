/**
 * @Title:UserDao.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:Your Company
 *
 * @author Your Name
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao;

import com.bjsxt.pojo.User;



/**
 * @Title:UserDao 
 * @Description:TODO
 * @Company:Your Company
 *
 * @author Your Name
 * @data 2018年3月14日
 */
public interface UserDao {
	User login(String uname,String upwd);
}
