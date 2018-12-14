package com.bjsxt.yanbing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;
import com.bjsxt.yanbing.dao.MenuDao;
import com.bjsxt.yanbing.dao.UserDao;
import com.bjsxt.yanbing.dao.impl.MenuDaoImpl;
import com.bjsxt.yanbing.dao.impl.UserDaoImpl;
import com.bjsxt.yanbing.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	private MenuDao menuDao = new MenuDaoImpl();

	@Override
	public Map<String, Object> login(String uname, String upwd) {
		Map<String, Object> map = new HashMap<>();
		User user = userDao.login(uname, upwd);
		if (user == null) {
			return null;
		} else {
			map.put("user", user);
		}
		List<Menu> menus = menuDao.selByRid(user.getRoleId());
		map.put("menus", toTree(menus));

		return map;
	}

	private List<Menu> toTree(List<Menu> menus) {
		List<Menu> list = new ArrayList<>();

		// 创建一个临时容器, 用于将菜单和id一一对应
		Map<Integer, Menu> map = new HashMap<>();
		for (Menu menu : menus) {
			map.put(menu.getId(), menu);
		}
		System.out.println("临时map:" + map.toString());

		for (Menu menu : menus) {
			// 一级菜单
			if (menu.getPid() == 0) {
				list.add(menu);
				continue;
			}
			// 如果不是一级菜单，二三四级等通用
			Menu father = map.get(menu.getPid());

			// 将子菜单放入父菜单的children集合中
			father.getChildren().add(menu);
		}

		return list;
	}

	@Override
	public boolean updPwd(int id, String opwd, String npwd) {
		User user = userDao.selByIdPwd(id, opwd);
		if (user == null) {
			return false;
		}
		return userDao.updPwd(id, npwd);
	}
}
