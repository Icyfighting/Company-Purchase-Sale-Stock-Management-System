package com.bjsxt.yanbing.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Client;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Sale;
import com.bjsxt.util.DateUtil;
import com.bjsxt.yanbing.service.SaleService;
import com.bjsxt.yanbing.service.impl.SaleServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/sale")
public class SaleServlet extends BaseServlet {

	SaleService saleService = new SaleServiceImpl();

	public void addSale(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("method:" + req.getParameter("method"));
		System.out.println("productId"
				+ Integer.parseInt(req.getParameter("productId")));
		System.out.println("price"
				+ Double.parseDouble(req.getParameter("price")));

		System.out.println("number:" + req.getParameter("number"));

		Sale sale = getParams(req);
		boolean result = saleService.insSale(sale);
		resp.getWriter().print(result);

	}

	public void selAllClient(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Client> list = saleService.selAllClients();
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(list));
	}
	// 查询销售记录

	public void saleList(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		String column = req.getParameter("column");
		String operator = req.getParameter("operator");
		String srchVal = req.getParameter("srchVal"); // 日期查询 String startDate =
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		// System.out.println("saleServlet开始日期：" + startDate);
		// System.out.println("saleServlet结束日期：" + endDate);
		Pagination<Sale> p = saleService.selAllSale(page, rows, column,
				operator, srchVal, startDate, endDate);
		resp.setContentType("application/json;charset=utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		resp.getWriter().print(gson.toJson(p));
	}

	public Sale getParams(HttpServletRequest req) {
		System.out.println("clientId:"
				+ Integer.parseInt(req.getParameter("clientId")));
		System.out.println("sdate:"
				+ DateUtil.pStringToDate(req.getParameter("sdate"),
						"yyyy-MM-dd"));
		System.out.println("operator:" + req.getParameter("operator"));
		System.out.println("brokerage:" + req.getParameter("brokerage"));
		System.out.println("settlement:" + req.getParameter("settlement"));
		System.out.println("productId"
				+ Integer.parseInt(req.getParameter("productId")));
		System.out.println("price"
				+ Double.parseDouble(req.getParameter("price")));
		System.out.println("number:"
				+ Integer.parseInt(req.getParameter("number")));
		System.out.println("actualIncome:"
				+ Double.parseDouble(req.getParameter("actualIncome")));

		Sale sale = new Sale();
		sale.setClientId(Integer.parseInt(req.getParameter("clientId")));
		try {// 之后要转换一下，用日期插件
			sale.setSdate(DateUtil.pStringToDate(req.getParameter("sdate"),
					"yyyy-MM-dd"));
		} catch (Exception e) {
		}
		sale.setOperator(req.getParameter("operator"));
		sale.setBrokerage(req.getParameter("brokerage"));
		sale.setSettlement(req.getParameter("settlement"));
		sale.setProductId(Integer.parseInt(req.getParameter("productId")));
		sale.setPrice(Double.parseDouble(req.getParameter("price")));
		sale.setNumber(Integer.parseInt(req.getParameter("number")));
		sale.setActualIncome(Double.parseDouble(req
				.getParameter("actualIncome")));

		return sale;
	}
}
