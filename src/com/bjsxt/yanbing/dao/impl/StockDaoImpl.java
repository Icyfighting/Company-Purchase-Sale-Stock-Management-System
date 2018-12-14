package com.bjsxt.yanbing.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.pojo.Stock;
import com.bjsxt.yanbing.dao.StockDao;

public class StockDaoImpl extends BaseDao implements StockDao {

	@Override
	public List<Stock> selAllStock(int start, int size) {
		List<Stock> list = new ArrayList<>();
		List<Stock> temp = new ArrayList<>();
		String sql = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock limit ?,?";
		temp = query(Stock.class, sql, start, size);
		if (temp != null) {
			list = temp;
		}
		return list;
	}

	@Override
	public int selStockCount() {
		String sql = "select count(*) from t_stock";
		return queryCount(sql);
	}
	// 根据库存编号查询
	@Override
	public List<Stock> selById(int start, int size, int id, int operator) {
		// 根据operator来决定sql语句拼接
		List<Stock> list = new ArrayList<>();
		List<Stock> temp = new ArrayList<>();// 防止list返回出现null的情况，使得返回pagination中没有rows，造成页面无法刷新
		String sql1 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where id>? limit ?,?";
		String sql2 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where id=? limit ?,?";
		String sql3 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where id<? limit ?,?";
		System.out.println("stockDaoImpl:中的operator:" + operator);
		System.out.println("stockDaoImpl:中的id:" + id);
		if (operator == 1) {
			temp = query(Stock.class, sql1, id, start, size);
		} else if (operator == 2) {
			temp = query(Stock.class, sql2, id, start, size);
		} else if (operator == 3) {
			temp = query(Stock.class, sql3, id, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		// System.out.println("stockDaoImpl:中的list:" + list);
		return list;
	}

	@Override
	public List<Stock> selByNum(int start, int size, int number, int operator) {
		// 根据operator来决定sql语句拼接
		List<Stock> list = new ArrayList<>();
		List<Stock> temp = new ArrayList<>();// 防止list返回出现null的情况，使得返回pagination中没有rows，造成页面无法刷新
		String sql1 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where number>? limit ?,?";
		String sql2 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where number=? limit ?,?";
		String sql3 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where number<? limit ?,?";
		System.out.println("stockDaoImpl:中的operator:" + operator);
		System.out.println("stockDaoImpl:中的id:" + number);
		if (operator == 1) {
			temp = query(Stock.class, sql1, number, start, size);
		} else if (operator == 2) {
			temp = query(Stock.class, sql2, number, start, size);
		} else if (operator == 3) {
			temp = query(Stock.class, sql3, number, start, size);
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
		String sql1 = "select count(*) from t_stock where id>?";
		String sql2 = "select count(*) from t_stock where id=?";
		String sql3 = "select count(*) from t_stock where id<?";
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
	public int selCountByNum(int number, int operator) {
		int count = 0;
		String sql1 = "select count(*) from t_stock where number>?";
		String sql2 = "select count(*) from t_stock where number=?";
		String sql3 = "select count(*) from t_stock where number<?";
		if (operator == 1) {
			count = queryCount(sql1, number);
		} else if (operator == 2) {
			count = queryCount(sql2, number);
		} else if (operator == 3) {
			count = queryCount(sql3, number);
		}

		return count;
	}

	@Override
	public List<Stock> selByName(int start, int size, String value, int operator) {
		List<Stock> list = new ArrayList<>();
		List<Stock> temp = new ArrayList<>();// 防止list返回出现null的情况，使得返回pagination中没有rows，造成页面无法刷新
		String sql1 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where product_name like '%"
				+ value + "%' limit ?,?";
		String sql2 = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where product_name=? limit ?,?";

		if (operator == 1 || operator == 3) {
			temp = query(Stock.class, sql1, start, size);
		} else if (operator == 2) {
			temp = query(Stock.class, sql2, value, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		// System.out.println("stockDaoImpl:中的list:" + list);
		return list;
	}

	@Override
	public int selCountByName(String value, int operator) {
		int count = 0;
		String sql1 = "select * from t_stock where product_name like '%"
				+ value + "%' ";
		String sql2 = "select count(*) from t_stock where product_name =? ";

		if (operator == 1 || operator == 3) {
			count = queryCount(sql1);
		} else if (operator == 2) {
			count = queryCount(sql2, value);
		}

		return count;

	}

	@Override
	public List<Stock> selAllStock() {
		String sql = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock";
		return query(Stock.class, sql);
	}

	@Override
	public boolean updPrice(int productId, double nPrice) {
		String sql = "update t_stock set price=? where product_id=?;";
		return update(sql, nPrice, productId);
	}

	@Override
	public boolean updNumber(int productId, int number) {// 需改对应商品库存数量,number为计算了之后，应该set的值。
		String sql = "update t_stock set number=? where product_id=?";
		return update(sql, number, productId);
	}

	@Override
	public int selNumById(int productId) {
		String sql = "select number from t_stock where product_id=?";
		return queryCount(sql, productId);
	}

	@Override
	public boolean insStock(Stock stock) {
		String sql = "insert into t_stock values (default,?,?,?,?,?,?,?,?,?)";
		Object[] params = {stock.getProductId(), stock.getProductName(),
				stock.getSname(), stock.getPlace(), stock.getStandard(),
				stock.getPacking(), stock.getUnit(), stock.getPrice(),
				stock.getNumber()};
		return update(sql, params);
	}

	@Override
	public Stock selByProId(int pid) {
		String sql = "select id,product_id productId,product_name productName,sname,place,standard,packing,unit,price,number from t_stock where product_id=?";

		return queryOne(Stock.class, sql, pid);
	}

}
