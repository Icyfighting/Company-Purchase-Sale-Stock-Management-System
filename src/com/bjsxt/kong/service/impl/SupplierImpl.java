package com.bjsxt.kong.service.impl;

import com.bjsxt.kong.dao.SupplierDao;
import com.bjsxt.kong.dao.impl.SupplierDaoImpl;
import com.bjsxt.kong.service.SupplierSercice;
import com.bjsxt.pojo.Supplier;

public class SupplierImpl implements SupplierSercice {
	// 创建实现类对象
	private SupplierDao supplierDao = new SupplierDaoImpl();
	@Override
	public boolean insSupplier(Supplier supplier) {

		return supplierDao.insSupplier(supplier);
	}

}
