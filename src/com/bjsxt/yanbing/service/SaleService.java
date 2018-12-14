package com.bjsxt.yanbing.service;

import java.util.List;

import com.bjsxt.pojo.Client;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Sale;

public interface SaleService {
	public boolean insSale(Sale sale);
	public List<Client> selAllClients();
	public Pagination<Sale> selAllSale(int page, int rows, String column,
			String operator, String srchVal, String startDate, String endDate);
}
