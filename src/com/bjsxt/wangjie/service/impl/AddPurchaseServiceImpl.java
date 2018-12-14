/**
 * @Title:AddInStorageServiceImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月15日
 * @version 1.0
 */
package com.bjsxt.wangjie.service.impl;

import com.bjsxt.pojo.Purchase;
import com.bjsxt.wangjie.dao.AddPurchaseDao;
import com.bjsxt.wangjie.dao.AddStockDao;
import com.bjsxt.wangjie.dao.impl.AddPurchaseDaoImpl;
import com.bjsxt.wangjie.dao.impl.AddStockDaoImpl;
import com.bjsxt.wangjie.service.AddPurchaseService;

/**
 * @Title:AddInStorageServiceImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月15日
 */
public class AddPurchaseServiceImpl implements AddPurchaseService {
	private AddPurchaseDao addPurchaseDao = new AddPurchaseDaoImpl();
	private AddStockDao addStockDao = new AddStockDaoImpl();

	@Override
	public boolean addPurchase(Purchase purchase) {
		// TODO Auto-generated method stub

		return addPurchaseDao.addPurchase(purchase);
	}

}
