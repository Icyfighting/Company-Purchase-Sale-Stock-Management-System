package com.bjsxt.kong.service.impl;

import java.util.List;

import com.bjsxt.kong.dao.selClientDao;
import com.bjsxt.kong.dao.impl.selClientDaoImpl;
import com.bjsxt.kong.service.selClientService;
import com.bjsxt.pojo.Client;
import com.bjsxt.pojo.Pagination;

public class selClientServiceImpl implements selClientService {

	// 提供成员变量
	private selClientDao selClientDao = new selClientDaoImpl();

	@Override
	public Pagination<Client> selClientByPage(int page, int rows) {

		List<Client> list = selClientDao.selClientByPage((page - 1) * rows,
				rows);
		int total = selClientDao.selClientCount();
		Pagination<Client> p = new Pagination<>();
		p.setRows(list);
		p.setTotal(total);
		return p;
	}

}
