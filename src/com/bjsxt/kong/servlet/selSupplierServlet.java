package com.bjsxt.kong.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.kong.service.selSupplierService;
import com.bjsxt.kong.service.impl.selSupplierImpl;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Supplier;
import com.google.gson.Gson;

@WebServlet("/selSupplier")
public class selSupplierServlet extends BaseServlet {
	private selSupplierService selSupplierService = new selSupplierImpl();

	public void selSupplier(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 接收分页参数
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		// 设置响应头格式
		resp.setContentType("application/json; charset=utf-8");
		// 调用service
		Pagination<Supplier> p = selSupplierService.selSupplierByPage(page,
				rows);
		resp.getWriter().print(new Gson().toJson(p));

	}
}
