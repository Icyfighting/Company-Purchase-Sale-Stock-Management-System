package com.bjsxt.kong.service;

import com.bjsxt.pojo.Client;
import com.bjsxt.pojo.Pagination;

public interface selClientService {

	/**
	 * 分页查询用户
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	Pagination<Client> selClientByPage(int page, int rows);

}
