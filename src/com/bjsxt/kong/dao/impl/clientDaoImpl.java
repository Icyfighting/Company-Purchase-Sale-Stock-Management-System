package com.bjsxt.kong.dao.impl;

import com.bjsxt.kong.dao.ClientDao;
import com.bjsxt.pojo.Client;

public class clientDaoImpl extends BaseDao implements ClientDao {

	/**
	 * 添加用户
	 */

	@Override
	public boolean insClient(Client client) {
		String sql = "insert into t_client  values (default,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {client.getName(), client.getSname(),
				client.getAddress(), client.getZipcode(), client.getPhone(),
				client.getFax(), client.getContact(), client.getContactPhone(),
				client.getEmail(), client.getBank(), client.getAccountNumber()};
		return update(sql, params);
	}

}
