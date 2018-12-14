package com.bjsxt.zhang.service.impl;

import java.util.List;

import com.bjsxt.pojo.Role;
import com.bjsxt.zhang.dao.RoleDao;
import com.bjsxt.zhang.dao.impl.RoleDaoImpl;
import com.bjsxt.zhang.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao = new RoleDaoImpl();
	@Override
	public List<Role> selRole() {

		return roleDao.selRole();
	}

}
