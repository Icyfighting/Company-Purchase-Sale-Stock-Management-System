package com.bjsxt.yanbing.service;

import java.util.Map;

public interface UserService {
	Map<String, Object> login(String uname, String upwd);

	boolean updPwd(int id, String opwd, String npwd);
}
