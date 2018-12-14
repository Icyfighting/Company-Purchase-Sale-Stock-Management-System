package com.bjsxt.kong.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.kong.service.SupplierSercice;
import com.bjsxt.kong.service.impl.SupplierImpl;
import com.bjsxt.pojo.Supplier;
@WebServlet("/insSupplier")
public class SupplierServlet extends BaseServlet {

	private SupplierSercice supplierSercice = new SupplierImpl();

	public void insSupplier(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Supplier supplier = getParam(req);
		resp.getWriter().print(supplierSercice.insSupplier(supplier));

	}
	private Supplier getParam(HttpServletRequest req) {
		// 创建对象 作为返回值
		Supplier supplier = new Supplier();
		supplier.setName(req.getParameter("name"));
		supplier.setAddress(req.getParameter("address"));
		supplier.setSname(req.getParameter("sname"));
		supplier.setZipcode(req.getParameter("zipcode"));
		supplier.setPhone(req.getParameter("phone"));
		supplier.setFax(req.getParameter("fax"));
		supplier.setContact(req.getParameter("contact"));
		supplier.setContactPhone(req.getParameter("contactPhone"));
		supplier.setEmail(req.getParameter("email"));
		supplier.setBank(req.getParameter("bank"));
		supplier.setAccountNumber(req.getParameter("accountNumber"));
		return supplier;
	}
}
