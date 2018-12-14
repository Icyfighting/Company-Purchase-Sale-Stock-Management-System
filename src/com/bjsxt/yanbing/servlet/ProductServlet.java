package com.bjsxt.yanbing.servlet;

import java.io.IOException;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Supplier;
import com.bjsxt.yanbing.service.ProductService;
import com.bjsxt.yanbing.service.impl.ProductServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@WebServlet("/product")
public class ProductServlet extends BaseServlet {

	ProductService productService = new ProductServiceImpl();

	public void productList(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		String column = req.getParameter("column");
		String operator = req.getParameter("operator");
		String srchVal = req.getParameter("srchVal");

		Pagination<Product> p = productService.selAllProduct(page, rows,
				column, operator, srchVal);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(p));
	}

	public void selAllSupplier(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Supplier> list = productService.selAllSupplier();
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(list));
	}

	public void selAllProduct(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Product> list = productService.selAllProduct();
		resp.setContentType("application/json;charset=utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		resp.getWriter().print(gson.toJson(list));
	}

	public void insProduct(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		boolean result = productService.insProduct(getParam(req));
		resp.getWriter().print(result);
	}
	public Product getParam(HttpServletRequest req) {
		Product p = new Product();
		p.setName(req.getParameter("name"));
		p.setSname(req.getParameter("sname"));
		p.setPlace(req.getParameter("place"));
		p.setUnit(req.getParameter("unit"));
		p.setStandard(req.getParameter("standard"));
		p.setPacking(req.getParameter("packing"));
		p.setBatchno(req.getParameter("batchno"));
		p.setApproval(req.getParameter("approval"));
		p.setRemark(req.getParameter("remark"));
		p.setSupplierId(Integer.parseInt(req.getParameter("supplierId")));
		return p;
	}

	public void delProduct(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean result = productService.delById(id);
		resp.getWriter().print(result);

	}

	public void selById(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Product p = productService.selById(id);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(p));

	}
}
