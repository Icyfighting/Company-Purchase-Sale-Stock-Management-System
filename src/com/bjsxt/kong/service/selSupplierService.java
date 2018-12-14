package com.bjsxt.kong.service;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Supplier;

public interface selSupplierService {

	/**
	 * 分页查询供应商
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	Pagination<Supplier> selSupplierByPage(int page, int rows);

}
