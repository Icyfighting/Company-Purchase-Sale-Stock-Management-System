package com.bjsxt.yanbing.dao;

import java.util.List;

import com.bjsxt.pojo.Menu;

public interface MenuDao {
	List<Menu> selByRid(int rid);
}
