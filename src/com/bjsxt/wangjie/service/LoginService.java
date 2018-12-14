/**
 * @Title:LoginService.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:Your Company
 *
 * @author Your Name
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.service;

import com.bjsxt.pojo.User;

/**
 * @Title:LoginService
 * @Description:TODO
 * @Company:Your Company
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public interface LoginService {
	User login(String uname, String upwd);
}
