package com.bjsxt.yanbing.service.impl;

import java.util.List;

import com.bjsxt.pojo.InStorage;
import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Stock;
import com.bjsxt.yanbing.dao.InstorageDao;
import com.bjsxt.yanbing.dao.StockDao;
import com.bjsxt.yanbing.dao.impl.InstorageDaoImpl;
import com.bjsxt.yanbing.dao.impl.StockDaoImpl;
import com.bjsxt.yanbing.service.InstorageService;

public class InstorageServiceImpl implements InstorageService {
	InstorageDao instorageDao = new InstorageDaoImpl();
	StockDao stockDao = new StockDaoImpl();

	@Override
	public boolean insInstorage(InStorage inStorage, Product product) {
		// 进行两个表t_instorage和t_stock的更新
		// 1.对stock表进行查询，如果有相同product_id,则只进行库存该行信息数量的修改，如果没有相同的product_id，则进行插入stock的操作
		Stock stock = stockDao.selByProId(inStorage.getProductId());
		System.out.println("productId:" + inStorage.getProductId());
		int stockNum = 0;// 库存原来的数量
		int instorageNum = inStorage.getNumber();// 入库数量
		boolean result = false;
		System.out.println("stock：" + stock);
		if (stock != null) {// 说明库存表中已经有了该productId的库存。
			// 更新后的数量
			stockNum = stock.getNumber();
			int newNum = stockNum + instorageNum;
			result = stockDao.updNumber(inStorage.getProductId(), newNum);
			System.out.println("库存表更新数量结果：" + result);
		} else {// 说明库存中没有该productId的库存，增加一条
			result = stockDao.insStock(getParam(product, inStorage));
			System.out.println("库存表插入新条目结果" + result);
		}
		// 库存表更新结果判断，成功则继续添加入库表
		if (result) {
			result = instorageDao.insInstorage(inStorage);
			System.out.println("入库记录表插入结果：" + result);
		}

		// 2.stock表操作成功之后，对instorage表进行插入操作。
		return result;
	}
	public Stock getParam(Product product, InStorage inStorage) {
		Stock stock = new Stock();
		stock.setProductId(product.getId());
		stock.setProductName(product.getName());
		stock.setSname(product.getSname());
		stock.setPlace(product.getPlace());
		stock.setStandard(product.getStandard());
		stock.setPacking(product.getPacking());
		stock.setUnit(product.getUnit());
		stock.setPrice(inStorage.getPrice());
		stock.setNumber(inStorage.getNumber());

		return stock;
	}

}
