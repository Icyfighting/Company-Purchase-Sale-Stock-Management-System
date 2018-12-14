/**
 * @Title:InStorageServlet.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Purchase;
import com.bjsxt.wangjie.service.PurchaseService;
import com.bjsxt.wangjie.service.impl.PurchaseServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Title:InStorageServlet
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
@WebServlet("/purchase")
public class PurchaseServlet extends BaseServlet {
	private PurchaseService PurchaseService = new PurchaseServiceImpl();
	public void selPurchase(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));

		Pagination<Purchase> p = PurchaseService.selPurchaseByPage(page, rows);
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		resp.getWriter().print(gson.toJson(p));

	}
}
