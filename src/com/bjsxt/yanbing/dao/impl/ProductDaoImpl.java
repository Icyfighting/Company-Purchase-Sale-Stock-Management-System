package com.bjsxt.yanbing.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.pojo.Product;
import com.bjsxt.yanbing.dao.ProductDao;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public List<Product> selAllProduct(int start, int size) {
		String sql = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id limit ?,?";
		return query(Product.class, sql, start, size);
	}

	@Override
	public int selProductCount() {
		String sql = "select count(*) from t_product";
		return queryCount(sql);
	}

	@Override
	public List<Product> selById(int start, int size, int id, int operator) {
		// 根据operator来决定sql语句拼接
		List<Product> list = new ArrayList<>();
		List<Product> temp = new ArrayList<>();// 防止list返回出现null的情况，使得返回pagination中没有rows，造成页面无法刷新
		String sql1 = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id where p.id>? limit ?,?";
		String sql2 = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id where p.id=? limit ?,?";
		String sql3 = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id where p.id<? limit ?,?";
		// System.out.println("stockDaoImpl:中的operator:" + operator);
		// System.out.println("stockDaoImpl:中的id:" + id);
		if (operator == 1) {
			temp = query(Product.class, sql1, id, start, size);
		} else if (operator == 2) {
			temp = query(Product.class, sql2, id, start, size);
		} else if (operator == 3) {
			temp = query(Product.class, sql3, id, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		// System.out.println("stockDaoImpl:中的list:" + list);
		return list;
	}

	@Override
	public int selCountById(int id, int operator) {
		int count = 0;
		String sql1 = "select count(*) from t_product p left join t_supplier s on p.supplier_id=s.id where p.id>?";
		String sql2 = "select count(*) from t_product p left join t_supplier s on p.supplier_id=s.id where p.id=?";
		String sql3 = "select count(*) from t_product p left join t_supplier s on p.supplier_id=s.id where p.id<?";
		if (operator == 1) {
			count = queryCount(sql1, id);
		} else if (operator == 2) {
			count = queryCount(sql2, id);
		} else if (operator == 3) {
			count = queryCount(sql3, id);
		}

		return count;
	}

	@Override
	public List<Product> selByProName(int start, int size, String value,
			int operator) {
		List<Product> list = new ArrayList<>();
		List<Product> temp = new ArrayList<>();// 防止list返回出现null的情况，使得返回pagination中没有rows，造成页面无法刷新
		String sql1 = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id where p.name like '%"
				+ value + "%' limit ?,?";
		String sql2 = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id where p.name =? limit ?,?";

		if (operator == 1 || operator == 3) {
			temp = query(Product.class, sql1, start, size);
		} else if (operator == 2) {
			temp = query(Product.class, sql2, value, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		// System.out.println("stockDaoImpl:中的list:" + list);
		return list;
	}

	@Override
	public int selCountByProName(String value, int operator) {
		int count = 0;
		String sql1 = "select count(*) from t_product p left join t_supplier s on p.supplier_id=s.id where p.name like '%"
				+ value + "%'";
		String sql2 = "select count(*) from t_product p left join t_supplier s on p.supplier_id=s.id where p.name =?";

		if (operator == 1 || operator == 3) {
			count = queryCount(sql1);
		} else if (operator == 2) {
			count = queryCount(sql2, value);
		}

		return count;

	}

	@Override
	public List<Product> selBySupName(int start, int size, String value,
			int operator) {
		List<Product> list = new ArrayList<>();
		List<Product> temp = new ArrayList<>();// 防止list返回出现null的情况，使得返回pagination中没有rows，造成页面无法刷新
		String sql1 = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id where s.name like '%"
				+ value + "%' limit ?,?";
		String sql2 = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id where s.name =? limit ?,?";

		if (operator == 1 || operator == 3) {
			temp = query(Product.class, sql1, start, size);
		} else if (operator == 2) {
			temp = query(Product.class, sql2, value, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		// System.out.println("stockDaoImpl:中的list:" + list);
		return list;
	}

	@Override
	public int selCountBySupName(String value, int operator) {
		int count = 0;
		String sql1 = "select count(*) from t_product p left join t_supplier s on p.supplier_id=s.id where s.name like '%"
				+ value + "%'";
		String sql2 = "select count(*) from t_product p left join t_supplier s on p.supplier_id=s.id where s.name =?";

		if (operator == 1 || operator == 3) {
			count = queryCount(sql1);
		} else if (operator == 2) {
			count = queryCount(sql2, value);
		}

		return count;

	}

	@Override
	public boolean insProduct(Product p) {
		String sql = "insert into t_product values (default,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {p.getName(), p.getSname(), p.getPlace(),
				p.getUnit(), p.getStandard(), p.getPacking(), p.getBatchno(),
				p.getApproval(), p.getRemark(), p.getSupplierId()};
		return update(sql, params);
	}

	@Override
	public boolean delById(int id) {
		String sql = "delete from t_product where id=?";
		return update(sql, id);
	}

	@Override
	public List<Product> selAllProduct() {
		String sql = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName from t_product p left join t_supplier s on p.supplier_id=s.id";
		return query(Product.class, sql);

	}

	@Override
	public Product selById(int id) {
		String sql = "select p.id,p.name,p.sname,place,unit,standard,packing,batchno,approval,remark,s.name supplierName,p.supplier_id supplierId from t_product p left join t_supplier s on p.supplier_id=s.id where p.id=?";
		return queryOne(Product.class, sql, id);
	}

}
