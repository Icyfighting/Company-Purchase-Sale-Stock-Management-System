package com.bjsxt.yanbing.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Stock;
import com.bjsxt.pojo.Supplier;
import com.bjsxt.yanbing.dao.ProductDao;
import com.bjsxt.yanbing.dao.SupplierDao;
import com.bjsxt.yanbing.dao.impl.ProductDaoImpl;
import com.bjsxt.yanbing.dao.impl.SupplierDaoImpl;
import com.bjsxt.yanbing.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = new ProductDaoImpl();
	SupplierDao supplierDao = new SupplierDaoImpl();

	@Override
	public Pagination<Product> selAllProduct(int page, int rows, String column,
			String operator, String srchVal) {

		Pagination<Product> p = new Pagination<>();
		int start = (page - 1) * rows;
		int size = rows;
		int total = 0;
		List<Product> list = new ArrayList<>();
		if (srchVal != null && !"".equals(srchVal)) {

			int oper = Integer.parseInt(operator);
			// 说明有搜索条件，需要查看搜索条件
			if ("1".equals(column)) {// 根据库存编号查询
				int val = Integer.parseInt(srchVal);
				list = productDao.selById(start, size, val, oper);
				total = productDao.selCountById(val, oper);
			} else if ("2".equals(column)) {// 根据商品名称
				list = productDao.selByProName(start, size, srchVal, oper);
				total = productDao.selCountByProName(srchVal, oper);
			} else if ("3".equals(column)) {// 根据供应商名查询
				list = productDao.selBySupName(start, size, srchVal, oper);
				total = productDao.selCountBySupName(srchVal, oper);

			}

		} else {
			// 否则就是无条件搜索
			list = productDao.selAllProduct(start, size);
			total = productDao.selProductCount();
		}

		p.setRows(list);
		p.setTotal(total);
		return p;
	}

	public List<Supplier> selAllSupplier() {
		return supplierDao.selAllSuppliers();
	}

	@Override
	public boolean insProduct(Product p) {
		return productDao.insProduct(p);
	}

	@Override
	public boolean delById(int id) {
		return productDao.delById(id);
	}

	@Override
	public List<Product> selAllProduct() {
		return productDao.selAllProduct();
	}

	@Override
	public Product selById(int id) {
		return productDao.selById(id);
	}

}
