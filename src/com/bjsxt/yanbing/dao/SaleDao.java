package com.bjsxt.yanbing.dao;

import java.util.Date;
import java.util.List;

import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Sale;

public interface SaleDao {
	boolean insSale(Sale sale);

	List<Sale> selByDate(int start, int size, String startDate, String endDate);
	int selCountByDate(String sDate, String eDate);

	List<Sale> selById(int start, int size, int id, int operator, String sDate,
			String eDate);
	int selCountById(int id, int operator, String sDate, String eDate);

	List<Sale> selByProName(int start, int size, String value, int operator,
			String sDate, String eDate);
	int selCountByProName(String value, int operator, String sDate, String eDate);

	List<Sale> selByCltName(int start, int size, String value, int operator,
			String sDate, String eDate);
	int selCountByCltName(String value, int operator, String sDate, String eDate);
}
