package com.bjsxt.kong.dao.impl;

import java.util.List;

import com.bjsxt.kong.dao.selSupplierDao;
import com.bjsxt.pojo.Supplier;

public class selSupplierDaoImpl extends BaseDao implements selSupplierDao {

	@Override
	public List<Supplier> selSupplierByPage(int start, int size) {
		String sql = "SELECT id,name,sname,address,zipcode,phone,fax,contact,contact_phone contactPhone,email,bank,account_number accountNumber from t_supplier limit ?,?";

		return query(Supplier.class, sql, start, size);
	}

	@Override
	public int selSupplierCount() {

		String sql = "select count(*) from t_supplier";
		return queryCount(sql);
	}

}
