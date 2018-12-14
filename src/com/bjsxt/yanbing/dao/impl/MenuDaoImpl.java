package com.bjsxt.yanbing.dao.impl;

import java.util.List;

import com.bjsxt.pojo.Menu;
import com.bjsxt.yanbing.dao.MenuDao;

public class MenuDaoImpl extends BaseDao implements MenuDao {

	@Override
	public List<Menu> selByRid(int rid) {
		System.out.println("rid:" + rid);
		String sql = "select m.* from t_menu m left join t_role_menu rm on m.id=rm.menu_id where rm.role_id=?";
		List<Menu> list = query(Menu.class, sql, rid);
		// System.out.println("daoimpl:" + list);
		return list;
	}

}
