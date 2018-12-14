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

import com.bjsxt.pojo.InStorage;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.wangjie.service.InStorageService;
import com.bjsxt.wangjie.service.impl.InStorageServiceImpl;
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
@WebServlet("/instorage1")
public class InStorageServlet extends BaseServlet {
	private InStorageService inStorageService = new InStorageServiceImpl();
	public void selInStorage(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));

		Pagination<InStorage> p = inStorageService.selInStorageByPage(page,
				rows);
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		resp.getWriter().print(gson.toJson(p));
	}
}
