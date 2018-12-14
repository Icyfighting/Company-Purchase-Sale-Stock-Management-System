package com.bjsxt.yanbing.servlet;

import java.io.IOException;
import java.util.List;

import javax.enterprise.inject.New;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Stock;
import com.bjsxt.yanbing.service.StockService;
import com.bjsxt.yanbing.service.impl.StockServiceImpl;
import com.google.gson.Gson;

@WebServlet("/stock")
public class StockServlet extends BaseServlet {

	StockService stockService = new StockServiceImpl();

	public void selStock(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		String column = req.getParameter("column");
		String operator = req.getParameter("operator");
		String srchVal = req.getParameter("srchVal");
		System.out.println("stockServlet接收到的参数:" + column + "-" + operator
				+ "-" + srchVal);
		Pagination<Stock> p = stockService.selAllStock(page, rows, column,
				operator, srchVal);
		// System.out.println("测试selStock：" + p);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(p));
	}

	public void selColumn(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Stock> list = stockService.selColumn();
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(list));
	}

	public void selStockName(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Stock> stocks = stockService.selAllStock();
		req.getSession().setAttribute("stocks", stocks);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(stocks));
	}

	public void selByName(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String srchVal = req.getParameter("srchVal");
		List<Stock> list = stockService.selByName(srchVal);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(list));
	}

	public void updPrice(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {// 修改库存价格，库存价格应该是售价，否则也不必要修改，商品进价在购买表t_purchase表中表示
		int productId = Integer.parseInt(req.getParameter("productId"));
		double nPrice = Double.parseDouble(req.getParameter("price"));
		System.out.println("测试：" + productId + "-" + nPrice);
		boolean result = stockService.updPrice(productId, nPrice);
		resp.getWriter().print(result);
	}
}
