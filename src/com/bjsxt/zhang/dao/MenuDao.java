package com.bjsxt.zhang.dao;

import java.util.List;

import com.bjsxt.pojo.Menu;

public interface MenuDao {

	List<Menu> selMenu(int roleId);
}
