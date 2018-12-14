package com.bjsxt.yanbing.dao.impl;

import java.util.List;

import com.bjsxt.pojo.Supplier;
import com.bjsxt.yanbing.dao.SupplierDao;

public class SupplierDaoImpl extends BaseDao implements SupplierDao {

	@Override
	public List<Supplier> selAllSuppliers() {
		// String sql =
		// "select id,name,sname,address,zipcode,phone,fax,contact,contact_phone contactPhone,bank,account_number accountNumber from t_supplier";
		String sql = "select id,name from t_supplier";
		return query(Supplier.class, sql);
	}

}
