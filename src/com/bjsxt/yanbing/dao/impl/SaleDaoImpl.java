package com.bjsxt.yanbing.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Sale;
import com.bjsxt.yanbing.dao.SaleDao;

public class SaleDaoImpl extends BaseDao implements SaleDao {

	@Override
	public boolean insSale(Sale sale) {
		String sql = "insert into t_sale values (default,?,?,?,?,?,?,?,?,?)";
		Object[] params = {sale.getClientId(), sale.getSdate(),
				sale.getOperator(), sale.getBrokerage(), sale.getSettlement(),
				sale.getProductId(), sale.getPrice(), sale.getNumber(),
				sale.getActualIncome()};
		return update(sql, params);
	}

	@Override
	public List<Sale> selByDate(int start, int size, String startDate,
			String endDate) {
		/*
		 * System.out.println("saleDao:" + startDate.toString()); String d1 =
		 * "'2018-02-02'"; DateFormat dFormat = new SimpleDateFormat(); String
		 * d2 = dFormat.format(new Date());
		 */
		String sql = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id "
				+ " where sdate >= ? and sdate <= ? limit ?,?";
		System.out.println("startDate:" + startDate);
		System.out.println("endDate:" + endDate);
		return query(Sale.class, sql, startDate, endDate, start, size);
	}

	@Override
	public int selCountByDate(String startDate, String endDate) {
		String sql = "select count(*) from t_sale where sdate >= ? and ?";

		return queryCount(sql, startDate, endDate);
	}

	@Override
	public List<Sale> selById(int start, int size, int id, int operator,
			String sDate, String eDate) {
		List<Sale> list = new ArrayList<>();
		List<Sale> temp = new ArrayList<>();// 防止list返回出现null的情况，使得返回pagination中没有rows，造成页面无法刷新

		String sql1 = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id  where s.id>? and sdate >= ? and sdate <= ? limit ?,?";
		String sql2 = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id  where s.id=? and sdate >= ? and sdate <= ? limit ?,?";
		String sql3 = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id  where s.id<? and sdate >= ? and sdate <= ? limit ?,?";
		if (operator == 1) {
			temp = query(Sale.class, sql1, id, sDate, eDate, start, size);
		} else if (operator == 2) {
			temp = query(Sale.class, sql2, id, sDate, eDate, start, size);
		} else if (operator == 3) {
			temp = query(Sale.class, sql3, id, sDate, eDate, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		return list;
	}

	@Override
	public int selCountById(int id, int operator, String sDate, String eDate) {
		int count = 0;
		String sql1 = "select count(*) from t_sale where id>? and sdate >= ? and sdate <= ?";
		String sql2 = "select count(*) from t_sale where id=? and sdate >= ? and sdate <= ?";
		String sql3 = "select count(*) from t_sale where id<? and sdate >= ? and sdate <= ?";
		if (operator == 1) {
			count = queryCount(sql1, id, sDate, eDate);
		} else if (operator == 2) {
			count = queryCount(sql2, id, sDate, eDate);
		} else if (operator == 3) {
			count = queryCount(sql3, id, sDate, eDate);
		}

		return count;
	}

	@Override
	public List<Sale> selByProName(int start, int size, String value,
			int operator, String sDate, String eDate) {
		List<Sale> list = new ArrayList<>();
		List<Sale> temp = new ArrayList<>();
		String sql1 = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id  where p.name like '%"
				+ value + "%' and sdate >= ? and sdate <= ? limit ?,?";
		String sql2 = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id  where p.name =? and sdate >= ? and sdate <= ? limit ?,?";
		if (operator == 1 || operator == 3) {
			temp = query(Sale.class, sql1, sDate, eDate, start, size);
		} else if (operator == 2) {
			temp = query(Sale.class, sql2, value, sDate, eDate, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		return list;
	}

	@Override
	public int selCountByProName(String value, int operator, String sDate,
			String eDate) {
		int count = 0;
		String sql1 = "select count(*) from t_sale s left join t_product p on s.product_id=p.id where p.name like'%"
				+ value + "%' and sdate >= ? and sdate <= ?";
		String sql2 = "select count(*) from t_sale s left join t_product p on s.product_id=p.id where p.name =? and sdate >= ? and sdate <= ?";
		if (operator == 1 || operator == 3) {
			count = queryCount(sql1, sDate, eDate);
		} else if (operator == 2) {
			count = queryCount(sql2, value, sDate, eDate);
		}
		return count;
	}

	@Override
	public List<Sale> selByCltName(int start, int size, String value,
			int operator, String sDate, String eDate) {
		List<Sale> list = new ArrayList<>();
		List<Sale> temp = new ArrayList<>();
		String sql1 = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id  where c.name like '%"
				+ value + "%' and sdate >= ? and sdate <= ? limit ?,?";
		String sql2 = "select s.id,c.name clientName,s.sdate,s.operator,s.brokerage,s.settlement,p.name productName,s.price,s.number,s.actual_income actualIncome from t_sale s left join t_client c on s.client_id=c.id left join t_product p on s.product_id=p.id  where c.name =? and sdate >= ? and sdate <= ? limit ?,?";
		if (operator == 1 || operator == 3) {
			temp = query(Sale.class, sql1, sDate, eDate, start, size);
		} else if (operator == 2) {
			temp = query(Sale.class, sql2, value, sDate, eDate, start, size);
		}
		if (temp != null) {
			list = temp;
		}
		return list;
	}

	@Override
	public int selCountByCltName(String value, int operator, String sDate,
			String eDate) {
		int count = 0;
		String sql1 = "select count(*) from t_sale s left join t_client c on s.client_id=c.id where c.name like'%"
				+ value + "%' and sdate >= ? and sdate <= ?";
		String sql2 = "select count(*) from t_sale s left join t_client c on s.client_id=c.id where c.name =? and sdate >= ? and sdate <= ?";
		if (operator == 1 || operator == 3) {
			count = queryCount(sql1, sDate, eDate);
		} else if (operator == 2) {
			count = queryCount(sql2, value, sDate, eDate);
		}
		return count;
	}

}
