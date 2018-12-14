/**
 * @Title:AddpurchaseDaoImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月15日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao.impl;

import com.bjsxt.pojo.Purchase;
import com.bjsxt.wangjie.dao.AddPurchaseDao;

/**
 * @Title:AddpurchaseDaoImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月15日
 */
public class AddPurchaseDaoImpl extends BaseDao implements AddPurchaseDao {

	@Override
	public boolean addPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		String sql = "insert into t_purchase values(default,?,?,?,?,?,?,?)";
		Object[] params = {

		purchase.getProductId(), purchase.getPdate(), purchase.getNumber(),
				purchase.getPrice(), purchase.getTotalAmount(),
				purchase.getRemark(), purchase.getSupplierId()

		};
		return update(sql, params);
	}

}
