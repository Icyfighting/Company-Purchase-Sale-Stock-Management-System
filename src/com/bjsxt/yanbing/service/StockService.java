package com.bjsxt.yanbing.service;

import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Stock;

public interface StockService {
	public Pagination<Stock> selAllStock(int page, int rows, String column,
			String operator, String srchVal);

	public List<Stock> selColumn();

	public List<Stock> selAllStock();

	public List<Stock> selByName(String srchVal);

	public boolean updPrice(int productId, double nPrice);

}
