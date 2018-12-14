package com.bjsxt.yanbing.dao;

import com.bjsxt.pojo.User;

public interface UserDao {
	User login(String uname, String upwd);

	User selByIdPwd(int id, String pwd);

	boolean updPwd(int id, String pwd);
}
