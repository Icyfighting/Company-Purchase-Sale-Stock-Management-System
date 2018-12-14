package com.bjsxt.kong.dao;

import com.bjsxt.pojo.Supplier;

public interface SupplierDao {
	/**
	 * 添加供应商
	 * 
	 * @param supplier
	 * @return
	 */
	boolean insSupplier(Supplier supplier);
}
