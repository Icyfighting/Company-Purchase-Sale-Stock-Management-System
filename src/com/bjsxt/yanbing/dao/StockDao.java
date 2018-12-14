package com.bjsxt.yanbing.dao;

import java.util.List;

import com.bjsxt.pojo.Stock;

public interface StockDao {
	List<Stock> selAllStock(int start, int size);
	int selStockCount();

	List<Stock> selById(int start, int size, int id, int operator);
	int selCountById(int id, int operator);

	List<Stock> selByNum(int start, int size, int id, int operator);
	int selCountByNum(int number, int operator);

	List<Stock> selByName(int start, int size, String value, int operator);
	int selCountByName(String value, int operator);

	List<Stock> selAllStock();

	boolean updPrice(int productId, double nPrice);

	boolean updNumber(int productId, int number);

	int selNumById(int productId);

	boolean insStock(Stock stock);

	Stock selByProId(int pid);

}
