/**
 * @Title:AddStockDaoImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月16日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao.impl;

import com.bjsxt.pojo.Stock;
import com.bjsxt.wangjie.dao.AddStockDao;

/**
 * @Title:AddStockDaoImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月16日
 */
public class AddStockDaoImpl extends BaseDao implements AddStockDao {

	@Override
	public boolean addStock(Stock stock) {
		// TODO Auto-generated method stub
		String sql = "insert into t_stock values(default,?,?,?,?,?,?,?,?,?)";
		Object[] params = {stock.getProductId(), stock.getProductName(),
				stock.getSname(), stock.getPlace(), stock.getUnit(),
				stock.getStandard(), stock.getPacking(), stock.getPrice(),
				stock.getNumber()};
		return update(sql, params);
	}

	@Override
	public boolean upStock(Stock stock) {
		// TODO Auto-generated method stub
		String sql = "update t_stock set number=? where product_id=?";
		return update(sql, stock.getNumber(), stock.getProductId());
	}

}
