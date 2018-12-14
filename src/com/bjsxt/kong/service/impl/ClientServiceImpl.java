package com.bjsxt.kong.service.impl;

import com.bjsxt.kong.dao.ClientDao;
import com.bjsxt.kong.dao.impl.clientDaoImpl;
import com.bjsxt.kong.service.ClientService;
import com.bjsxt.pojo.Client;

public class ClientServiceImpl implements ClientService {
	// 创建实现类对象
	private ClientDao clientDao = new clientDaoImpl();

	@Override
	public boolean insClient(Client client) {

		return clientDao.insClient(client);
	}

}
