package com.bjsxt.kong.dao.impl;

import java.util.List;

import com.bjsxt.kong.dao.selClientDao;
import com.bjsxt.pojo.Client;

public class selClientDaoImpl extends BaseDao implements selClientDao {

	@Override
	public List<Client> selClientByPage(int start, int size) {
		String sql = "SELECT id,name,sname,address,zipcode,phone,fax,contact,contact_phone contactPhone,email,bank,account_number accountNumber from t_client limit ?,?";

		return query(Client.class, sql, start, size);
	}

	@Override
	public int selClientCount() {
		String sql = "select count(*) from t_client";
		return queryCount(sql);
	}

}
