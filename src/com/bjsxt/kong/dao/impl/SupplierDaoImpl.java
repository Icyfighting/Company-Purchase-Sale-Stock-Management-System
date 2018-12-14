package com.bjsxt.kong.dao.impl;

import com.bjsxt.kong.dao.SupplierDao;
import com.bjsxt.pojo.Supplier;

public class SupplierDaoImpl extends BaseDao implements SupplierDao {

	@Override
	public boolean insSupplier(Supplier supplier) {

		String sql = "INSERT into t_supplier VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {supplier.getName(), supplier.getSname(),
				supplier.getAddress(), supplier.getZipcode(),
				supplier.getPhone(), supplier.getFax(), supplier.getContact(),
				supplier.getContactPhone(), supplier.getEmail(),
				supplier.getBank(), supplier.getAccountNumber()};
		return update(sql, params);
	}

}
