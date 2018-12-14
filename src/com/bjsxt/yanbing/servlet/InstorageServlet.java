package com.bjsxt.yanbing.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.InStorage;
import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Stock;
import com.bjsxt.util.DateUtil;
import com.bjsxt.yanbing.service.InstorageService;
import com.bjsxt.yanbing.service.impl.InstorageServiceImpl;

@WebServlet("/instorage")
public class InstorageServlet extends BaseServlet {

	InstorageService instorageService = new InstorageServiceImpl();

	public void insInstorage(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		InStorage inStorage = getParam1(req);// servlet调用service之前必须准备instorage和stock对象，因为虽然instorage的商品是从product表中获得的，但是不见得stock表中就有该库存
		// Stock stock = getParam2(req);
		Product product = getParam3(req);
		boolean result = instorageService.insInstorage(inStorage, product);
		resp.getWriter().print(result);
	}

	public InStorage getParam1(HttpServletRequest req) {
		InStorage inStorage = new InStorage();
		inStorage
				.setSupplierId(Integer.parseInt(req.getParameter("supplierId")));
		try {// 之后要转换一下，用日期插件
			inStorage.setIdate(DateUtil.pStringToDate(
					req.getParameter("idate"), "yyyy-MM-dd"));
		} catch (Exception e) {
		}
		inStorage.setOperator(req.getParameter("operator"));
		inStorage.setBrokerage(req.getParameter("brokerage"));
		inStorage.setSettlement(req.getParameter("settlement"));
		inStorage.setProductId(Integer.parseInt(req.getParameter("productId")));
		inStorage.setPrice(Double.parseDouble(req.getParameter("price")));
		inStorage.setNumber(Integer.parseInt(req.getParameter("number")));
		inStorage
				.setActualPay(Double.parseDouble(req.getParameter("actualPay")));

		return inStorage;
	}

	/*
	 * public Stock getParam2(HttpServletRequest req) { Stock stock = new
	 * Stock();
	 * stock.setProductId(Integer.parseInt(req.getParameter("productId")));
	 * stock.setProductName(req.getParameter("productName"));
	 * stock.setSname(req.getParameter("sname"));
	 * stock.setPlace(req.getParameter("place"));
	 * stock.setStandard(req.getParameter("standard"));
	 * stock.setPacking(req.getParameter("packing"));
	 * stock.setUnit(req.getParameter("unit"));
	 * stock.setPrice(Double.parseDouble(req.getParameter("price")));
	 * stock.setNumber(Integer.parseInt(req.getParameter("number")));
	 * 
	 * return stock; }
	 */

	public Product getParam3(HttpServletRequest req) {
		Product p = new Product();
		p.setId(Integer.parseInt(req.getParameter("productId")));
		p.setName(req.getParameter("name"));
		p.setSname(req.getParameter("sname"));
		p.setPlace(req.getParameter("place"));
		p.setUnit(req.getParameter("unit"));
		p.setStandard(req.getParameter("standard"));
		p.setPacking(req.getParameter("packing"));
		/*
		 * p.setBatchno(req.getParameter("batchno"));
		 * p.setApproval(req.getParameter("approval"));
		 * p.setRemark(req.getParameter("remark"));
		 */
		// p.setSupplierId(Integer.parseInt(req.getParameter("supplierId")));
		return p;
	}
}
