package com.bjsxt.zhang.dao.impl;

import java.util.List;

import com.bjsxt.pojo.Menu;
import com.bjsxt.zhang.dao.MenuDao;

public class MenuDaoImpl extends BaseDao implements MenuDao {

	@Override
	public List<Menu> selMenu(int roleId) {
		String sql = "select m.* from t_menu m left join t_role_menu rm on m.id=rm.menu_id where rm.role_id=?";
		return query(Menu.class, sql, roleId);
	}

}
