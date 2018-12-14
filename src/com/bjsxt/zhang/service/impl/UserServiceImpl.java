package com.bjsxt.zhang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;
import com.bjsxt.zhang.dao.MenuDao;
import com.bjsxt.zhang.dao.UserDao;
import com.bjsxt.zhang.dao.impl.MenuDaoImpl;
import com.bjsxt.zhang.dao.impl.UserDaoImpl;
import com.bjsxt.zhang.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	private MenuDao menuDao = new MenuDaoImpl();
	@Override
	public Map<String, Object> login(String name, String pwd) {

		Map<String, Object> map = new HashMap<>();
		// 登录
		User user = userDao.login(name, pwd);
		// 如果失败返回null
		if (user == null) {
			return null;
		}
		// 将用户存放进map中
		map.put("user", user);
		System.out.println(user);
		// 查询菜单
		List<Menu> menus = menuDao.selMenu(user.getRoleId());
		System.out.println(menus);
		// 将用户存放入listmap中
		map.put("menus", toTree(menus));
		return map;
	}

	private List<Menu> toTree(List<Menu> menus) {
		List<Menu> list = new ArrayList<>();
		// 创建一个临时容器，用于将菜单和id一一对应
		Map<Integer, Menu> map = new HashMap<>();
		for (Menu menu : menus) {
			map.put(menu.getId(), menu);
		}
		for (Menu menu : menus) {
			// 一级菜单
			if (menu.getPid() == 0) {
				list.add(menu);
				continue;
			}
			// 如果是二级菜单
			Menu father = map.get(menu.getPid());
			// 将子类菜单放入父菜单的children集合中
			father.getChildren().add(menu);
		}
		return list;
	}

	@Override
	public boolean updPwd(int id, String opwd, String npwd) {
		User user = userDao.selByIdPwd(id, opwd);
		return userDao.updPwd(id, npwd);
	}

	@Override
	public List<User> selById(int roleId) {

		return userDao.selById(roleId);
	}

	@Override
	public boolean insUser(User user) {

		return userDao.insUser(user);
	}

}
