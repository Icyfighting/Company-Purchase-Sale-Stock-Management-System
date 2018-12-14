package com.bjsxt.kong.service.impl;

import java.util.List;

import com.bjsxt.kong.dao.selSupplierDao;
import com.bjsxt.kong.dao.impl.selSupplierDaoImpl;
import com.bjsxt.kong.service.selSupplierService;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Supplier;

public class selSupplierImpl implements selSupplierService {

	private selSupplierDao selSupplierDao = new selSupplierDaoImpl();

	@Override
	public Pagination<Supplier> selSupplierByPage(int page, int rows) {

		List<Supplier> list = selSupplierDao.selSupplierByPage((page - 1)
				* rows, rows);
		int total = selSupplierDao.selSupplierCount();
		Pagination<Supplier> p = new Pagination<>();
		p.setRows(list);
		p.setTotal(total);
		return p;
	}

}
