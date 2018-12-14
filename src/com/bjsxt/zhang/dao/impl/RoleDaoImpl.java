package com.bjsxt.zhang.dao.impl;

import java.util.List;

import com.bjsxt.pojo.Role;
import com.bjsxt.zhang.dao.RoleDao;

public class RoleDaoImpl extends BaseDao implements RoleDao {

	@Override
	public List<Role> selRole() {
		String sql = "select * from t_role";
		return query(Role.class, sql);
	}

}
