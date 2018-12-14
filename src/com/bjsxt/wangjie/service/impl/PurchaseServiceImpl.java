/**
 * @Title:InStorageServiceImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.service.impl;

import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Purchase;
import com.bjsxt.wangjie.dao.PurchaseDao;
import com.bjsxt.wangjie.dao.impl.PurchaseDaoImpl;
import com.bjsxt.wangjie.service.PurchaseService;

/**
 * @Title:InStorageServiceImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public class PurchaseServiceImpl implements PurchaseService {
	private PurchaseDao PurchaseDao = new PurchaseDaoImpl();

	@Override
	public Pagination<Purchase> selPurchaseByPage(int page, int rows) {
		// TODO Auto-generated method stub
		Pagination<Purchase> p = new Pagination<>();

		List<Purchase> list = PurchaseDao.selPurchaseByPage((page - 1) * rows,
				rows);
		int total = PurchaseDao.selPurchaseCount();
		p.setRows(list);
		p.setTotal(total);
		return p;
	}
}
