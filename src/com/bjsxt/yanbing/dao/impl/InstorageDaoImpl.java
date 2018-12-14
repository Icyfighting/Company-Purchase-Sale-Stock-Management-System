package com.bjsxt.yanbing.dao.impl;

import com.bjsxt.pojo.InStorage;
import com.bjsxt.yanbing.dao.InstorageDao;

public class InstorageDaoImpl extends BaseDao implements InstorageDao {

	@Override
	public boolean insInstorage(InStorage instorage) {
		String sql = "insert into t_instorage values(default,?,?,?,?,?,?,?,?,?)";
		Object[] params = {instorage.getSupplierId(), instorage.getIdate(),
				instorage.getOperator(), instorage.getBrokerage(),
				instorage.getSettlement(), instorage.getProductId(),
				instorage.getPrice(), instorage.getNumber(),
				instorage.getActualPay()};
		return update(sql, params);
	}

}
