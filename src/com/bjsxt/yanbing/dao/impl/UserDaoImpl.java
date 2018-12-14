package com.bjsxt.yanbing.dao.impl;

import com.bjsxt.pojo.User;
import com.bjsxt.yanbing.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(String uname, String upwd) {
		// TODO Auto-generated method stub
		String sql = "select id, name, rname,role_id roleId from t_user where name=? and pwd=?";
		String sql2 = "select u.id,u.name,u.rname,u.role_id roleId,r.name roleName from t_user u left join t_role r on u.role_id=r.id where u.name=? and u.pwd=?";

		return queryOne(User.class, sql2, uname, upwd);
	}

	@Override
	public boolean updPwd(int id, String pwd) {
		String sql = "update t_user set pwd=? where id=?";
		return update(sql, pwd, id);
	}

	@Override
	public User selByIdPwd(int id, String pwd) {
		String sql = "select * from t_user where id=? and pwd=?";
		return queryOne(User.class, sql, id, pwd);
	}

}