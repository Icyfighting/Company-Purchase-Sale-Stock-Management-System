package com.bjsxt.kong.dao;

import java.util.List;

import com.bjsxt.pojo.Client;

public interface selClientDao {
	/**
	 * 分页查询用户信息
	 * 
	 * @param start
	 * @param size
	 * @return
	 */

	List<Client> selClientByPage(int start, int size);

	/**
	 * 查询用户总数
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	int selClientCount();
}
