/**
 * @Title:StockDao.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月16日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao;

import com.bjsxt.pojo.Stock;

/**
 * @Title:StockDao
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月16日
 */
public interface AddStockDao {
	boolean addStock(Stock stock);
	boolean upStock(Stock stock);
}
