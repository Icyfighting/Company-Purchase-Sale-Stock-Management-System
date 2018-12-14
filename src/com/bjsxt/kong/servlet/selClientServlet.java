package com.bjsxt.kong.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.kong.service.selClientService;
import com.bjsxt.kong.service.impl.selClientServiceImpl;
import com.bjsxt.pojo.Client;
import com.bjsxt.pojo.Pagination;
import com.google.gson.Gson;

@WebServlet("/selClient")
public class selClientServlet extends BaseServlet {
	private selClientService selClientService = new selClientServiceImpl();

	public void selClient(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 接收分页参数
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		// 设置响应头格式
		resp.setContentType("application/json;charset=utf-8");
		// 调用service
		Pagination<Client> p = selClientService.selClientByPage(page, rows);
		// 转换格式
		resp.getWriter().print(new Gson().toJson(p));
	}
}
