/**
 * @Title:PurchaseDao.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao;

import java.util.List;

import com.bjsxt.pojo.Purchase;

/**
 * @Title:PurchaseDao
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public interface PurchaseDao {

	/**
	 * @param start
	 * @param size
	 * @return
	 */
	List<Purchase> selPurchaseByPage(int start, int size);
	/**
	 * @return
	 */
	int selPurchaseCount();
}
