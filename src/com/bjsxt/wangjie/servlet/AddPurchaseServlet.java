/**
 * @Title:AddInStorageServlet.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月15日
 * @version 1.0
 */
package com.bjsxt.wangjie.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Purchase;
import com.bjsxt.util.DateUtil;
import com.bjsxt.wangjie.service.AddPurchaseService;
import com.bjsxt.wangjie.service.impl.AddPurchaseServiceImpl;

/**
 * @Title:AddInStorageServlet
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月15日
 */
@WebServlet("/addpurchase")
public class AddPurchaseServlet extends BaseServlet {

	private AddPurchaseService addPurchaseService = new AddPurchaseServiceImpl();
	public void AddPurchase(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ParseException {
		// 接收参数

		req.setCharacterEncoding("utf-8");
		Purchase purchase = getParam(req, resp);
		resp.getWriter().print(addPurchaseService.addPurchase(purchase));
	}

	private Purchase getParam(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Purchase purchase = new Purchase();

		purchase.setProductId(Integer.parseInt(req.getParameter("productId")));
		purchase.setSupplierId(Integer.parseInt(req.getParameter("supplierId")));
		try {
			purchase.setPdate(DateUtil.pStringToDate(req.getParameter("pdate"),
					"yyyy-MM-dd"));
		} catch (Exception e) {
		}
		purchase.setNumber(Integer.parseInt(req.getParameter("number")));
		purchase.setPrice(Double.parseDouble(req.getParameter("price")));
		purchase.setTotalAmount(Double.parseDouble(req
				.getParameter("totalAmount")));
		purchase.setRemark(req.getParameter("remark"));

		return purchase;
	}
}
