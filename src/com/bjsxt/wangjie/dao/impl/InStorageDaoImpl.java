/**
 * @Title:InStorageDaoImpl.java 
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

import com.bjsxt.pojo.InStorage;
import com.bjsxt.wangjie.dao.InStorageDao;

/**
 * @Title:InStorageDaoImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public class InStorageDaoImpl extends BaseDao implements InStorageDao {

	@Override
	public List<InStorage> selInStorageByPage(int start, int size) {
		// TODO Auto-generated method stub
		String sql = "select id ,supplier_id supplierId,idate,operator,brokerage,settlement,product_id productId,price,number,actual_pay actualPay from t_instorage limit ?,?";
		String sql2 = "select i.id,s.name,i.supplier_id supplierId,i.idate,i.operator,i.brokerage,i.settlement,i.product_id productId,i.price,i.number,i.actual_pay actualPay from t_instorage i left join t_supplier s on i.supplier_id=s.id limit ?,?";
		String sql3 = "select i.id,s.name supplierName,i.supplier_id supplierId,i.idate,i.operator,i.brokerage,i.settlement,i.product_id productId,p.name productName,i.price,i.number,i.actual_pay actualPay from t_instorage i left join t_supplier s on i.supplier_id=s.id left join t_product p on i.product_id=p.id limit ?,?";

		List<InStorage> query = query(InStorage.class, sql3, start, size);
		return query;
	}

	@Override
	public int selInStorageCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from t_instorage";
		return queryCount(sql);
	}

}
