package com.bjsxt.kong.dao;

import java.util.List;

import com.bjsxt.pojo.Supplier;

public interface selSupplierDao {

	/**
	 * 分页查询供应商信息
	 * 
	 * @return
	 */
	List<Supplier> selSupplierByPage(int start, int size);

	/**
	 * 查询供应商总数
	 */
	int selSupplierCount();
}
