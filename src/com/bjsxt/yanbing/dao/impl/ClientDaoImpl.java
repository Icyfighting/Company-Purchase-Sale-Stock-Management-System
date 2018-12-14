package com.bjsxt.yanbing.dao.impl;

import java.util.List;

import com.bjsxt.pojo.Client;
import com.bjsxt.yanbing.dao.ClientDao;

public class ClientDaoImpl extends BaseDao implements ClientDao {

	@Override
	public List<Client> selAllClients() {
		String sql = "select id,sname from t_client";
		return query(Client.class, sql);
	}

}
