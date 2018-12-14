/**
 * @Title:PurchaseDaoImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.dao.impl;

import java.util.List;

import com.bjsxt.pojo.Purchase;
import com.bjsxt.wangjie.dao.PurchaseDao;

/**
 * @Title:InStorageDaoImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public class PurchaseDaoImpl extends BaseDao implements PurchaseDao {

	@Override
	public List<Purchase> selPurchaseByPage(int start, int size) {
		// TODO Auto-generated method stub
		String sql = "select id ,product_id productId,pdate,number,price,total_amount totalAmount,remark  from t_purchase limit ?,?";
		String sql2 = "select c.id,c.product_id productId,c.pdate,c.number,c.price,c.total_amount totalAmount,c.remark,c.supplier_id supplierId,s.name supplierName,p.name productName from t_purchase c left join t_supplier s on c.supplier_id=s.id left join t_product p on c.product_id=p.id limit ?,?";
		List<Purchase> query = query(Purchase.class, sql2, start, size);
		return query;
	}

	@Override
	public int selPurchaseCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from t_purchase";
		return queryCount(sql);
	}

}
