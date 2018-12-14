package com.bjsxt.yanbing.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Stock;
import com.bjsxt.yanbing.dao.StockDao;
import com.bjsxt.yanbing.dao.impl.StockDaoImpl;
import com.bjsxt.yanbing.service.StockService;

public class StockServiceImpl implements StockService {
	private StockDao stockDao = new StockDaoImpl();

	@Override
	public Pagination<Stock> selAllStock(int page, int rows, String column,
			String operator, String srchVal) {
		Pagination<Stock> p = new Pagination<>();
		int start = (page - 1) * rows;
		int size = rows;
		int total = 0;

		List<Stock> list = new ArrayList<>();
		if (srchVal != null && !"".equals(srchVal)) {

			int oper = Integer.parseInt(operator);
			// 说明有搜索条件，需要查看搜索条件
			if ("1".equals(column)) {// 根据库存编号查询
				int val = Integer.parseInt(srchVal);
				list = stockDao.selById(start, size, val, oper);
				total = stockDao.selCountById(val, oper);
			} else if ("4".equals(column)) {// 根据商品库存数量查询
				int val = Integer.parseInt(srchVal);
				list = stockDao.selByNum(start, size, val, oper);
				total = stockDao.selCountByNum(val, oper);
			} else if ("2".equals(column)) {// 根据商品名查询
				list = stockDao.selByName(start, size, srchVal, oper);
				total = stockDao.selCountByName(srchVal, oper);

			}

		} else {
			// 否则就是无条件搜索
			list = stockDao.selAllStock(start, size);
			total = stockDao.selStockCount();
		}

		p.setRows(list);
		p.setTotal(total);
		return p;
	}
	@Override
	public List<Stock> selColumn() {
		return stockDao.selAllStock(0, 1);
	}
	@Override
	public List<Stock> selAllStock() {
		return stockDao.selAllStock();
	}
	@Override
	public List<Stock> selByName(String srchVal) {
		return stockDao.selByName(0, 1, srchVal, 2);
	}
	@Override
	public boolean updPrice(int productId, double nPrice) {
		return stockDao.updPrice(productId, nPrice);
	}

}
