/**
 * @Title:AddInStorageDaoImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月15日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao.impl;

import com.bjsxt.pojo.InStorage;
import com.bjsxt.wangjie.dao.AddInStorageDao;

/**
 * @Title:AddInStorageDaoImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月15日
 */
public class AddInStorageDaoImpl extends BaseDao implements AddInStorageDao {

	@Override
	public boolean addInStorage(InStorage inStorage) {
		// TODO Auto-generated method stub
		String sql = "insert into t_instorage values(default,?,?,?,?,?,?,?,?,?)";
		Object[] params = {

		inStorage.getSupplierId(), inStorage.getIdate(),
				inStorage.getOperator(), inStorage.getBrokerage(),
				inStorage.getSettlement(), inStorage.getProductId(),
				inStorage.getPrice(), inStorage.getNumber(),
				inStorage.getActualPay()};
		return update(sql, params);
	}

}
