package com.bjsxt.zhang.dao.impl;

import java.util.List;

import com.bjsxt.pojo.User;
import com.bjsxt.zhang.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(String name, String pwd) {
		String sql = "select id,name,rname,pwd,role_id roleId from t_user where name=? and pwd=?";

		User user = queryOne(User.class, sql, name, pwd);
		System.out.println(user);
		return user;
	}

	@Override
	public boolean updPwd(int id, String pwd) {
		String sql = "update t_user set pwd=? where id=?";
		return update(sql, pwd, id);
	}

	@Override
	public List<User> selById(int roleId) {
		String sql = "select * from t_user where role_id=?";

		return query(User.class, sql, roleId);
	}

	@Override
	public boolean insUser(User user) {
		String sql = "insert into t_user values(default,?,?,?,?)";
		return update(sql, user.getName(), user.getRname(), user.getPwd(),
				user.getRoleId());
	}

	@Override
	public User selByIdPwd(int id, String pwd) {
		String sql = "select * from t_user where id=? and pwd=?";
		return queryOne(User.class, sql, id, pwd);
	}

}
