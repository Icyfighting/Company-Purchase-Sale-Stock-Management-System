package com.bjsxt.kong.dao;

import com.bjsxt.pojo.Client;

public interface ClientDao {
	/**
	 * 添加用户
	 * 
	 * @param client
	 * @return
	 */
	boolean insClient(Client client);
}
