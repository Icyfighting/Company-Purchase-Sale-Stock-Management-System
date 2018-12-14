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

import com.bjsxt.pojo.InStorage;
import com.bjsxt.util.DateUtil;
import com.bjsxt.wangjie.service.AddInStorageService;
import com.bjsxt.wangjie.service.impl.AddInStorageServiceImpl;

/**
 * @Title:AddInStorageServlet
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月15日
 */
@WebServlet("/addinstorage")
public class AddInStorageServlet extends BaseServlet {

	private AddInStorageService addInStorageService = new AddInStorageServiceImpl();
	public void AddInStorage(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ParseException {
		// 接收参数

		req.setCharacterEncoding("utf-8");
		InStorage inStorage = getParam(req, resp);
		resp.getWriter().print(addInStorageService.addInStorage(inStorage));
	}

	private InStorage getParam(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		InStorage inStorage = new InStorage();
		try {
			String idString = req.getParameter("id");
			if (idString != null)
				inStorage.setId(Integer.parseInt(idString));
			inStorage.setSupplierId(Integer.parseInt(req
					.getParameter("supplierId")));

			inStorage.setIdate(DateUtil.pStringToDate(
					req.getParameter("idate"), "yyyy-MM-dd"));
			inStorage.setOperator(req.getParameter("operator"));
			inStorage.setBrokerage(req.getParameter("brokerage"));
			inStorage.setSettlement(req.getParameter("settlement"));
			inStorage.setProductId(Integer.parseInt(req
					.getParameter("productId")));
			// inStorage.setPrice(Integer.parseInt(req.getParameter("price")));
			inStorage.setPrice(Double.parseDouble(req.getParameter("price")));
			inStorage.setNumber(Integer.parseInt(req.getParameter("number")));
			// inStorage.setActualPay(Integer.parseInt(req.getParameter("actualPay")));
			inStorage.setActualPay(Double.parseDouble(req
					.getParameter("actualPay")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inStorage;
	}
}
