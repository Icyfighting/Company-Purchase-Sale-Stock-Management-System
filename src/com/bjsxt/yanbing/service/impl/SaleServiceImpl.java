package com.bjsxt.yanbing.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.pojo.Client;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Sale;
import com.bjsxt.util.DateUtil;
import com.bjsxt.yanbing.dao.ClientDao;
import com.bjsxt.yanbing.dao.SaleDao;
import com.bjsxt.yanbing.dao.StockDao;
import com.bjsxt.yanbing.dao.impl.ClientDaoImpl;
import com.bjsxt.yanbing.dao.impl.SaleDaoImpl;
import com.bjsxt.yanbing.dao.impl.StockDaoImpl;
import com.bjsxt.yanbing.service.SaleService;

public class SaleServiceImpl implements SaleService {
	StockDao stockDao = new StockDaoImpl();
	SaleDao saleDao = new SaleDaoImpl();
	ClientDao clientDao = new ClientDaoImpl();
	@Override
	public boolean insSale(Sale sale) {
		// 增加一条销售，顺序是：1、先去库存表中尝试修改，如果返回成功，说明可以销售，然后在销售记录表中增加一条记录
		// 这个时候应该先查询一下stock中id对应的真实number为多少，传过来的number是要卖的个数 ，比较两个的大小
		int productId = sale.getProductId();
		int saleNum = sale.getNumber();
		int realNum = stockDao.selNumById(productId);
		boolean result = false;
		if (realNum >= saleNum) {// 说明库存够
			result = stockDao.updNumber(productId, realNum - saleNum);// update的是销售后剩余的库存数量
			System.out.println("库存表更新结果：" + result);
			if (result) {
				result = saleDao.insSale(sale);// 库存更新成功，可以增加销售记录表了
				System.out.println("销售记录表更新结果：" + result);
			}
		}
		return result;
	}

	public List<Client> selAllClients() {
		return clientDao.selAllClients();
	}

	@Override
	public Pagination<Sale> selAllSale(int page, int rows, String column,
			String operator, String srchVal, String startDate, String endDate) {// 分页、根据查询条件及日期共同决定查询
		Pagination<Sale> p = new Pagination<>();
		int start = (page - 1) * rows;
		int size = rows;
		int total = 0;

		List<Sale> list = new ArrayList<>();
		if (startDate == null || "".equals(startDate)) {
			startDate = "1900-01-01";
		}
		if (endDate == null || "".equals(endDate)) {
			endDate = "2100-01-01";
		}

		if (srchVal != null && !"".equals(srchVal)) {

			int oper = Integer.parseInt(operator);
			// 说明有搜索条件，需要查看搜索条件
			if ("1".equals(column)) {// 根据库存编号查询
				int val = Integer.parseInt(srchVal);
				list = saleDao.selById(start, size, val, oper, startDate,
						endDate);
				total = saleDao.selCountById(val, oper, startDate, endDate);
			} else if ("2".equals(column)) {// 根据商品名称
				list = saleDao.selByProName(start, size, srchVal, oper,
						startDate, endDate);
				total = saleDao.selCountByProName(srchVal, oper, startDate,
						endDate);
			} else if ("3".equals(column)) {// 根据供应商名查询
				list = saleDao.selByCltName(start, size, srchVal, oper,
						startDate, endDate);
				total = saleDao.selCountByCltName(srchVal, oper, startDate,
						endDate);

			}

		} else {
			// 否则就是无条件搜索
			list = saleDao.selByDate(start, size, startDate, endDate);
			total = saleDao.selCountByDate(startDate, endDate);
		}

		p.setRows(list);
		p.setTotal(total);
		return p;
	}

}
