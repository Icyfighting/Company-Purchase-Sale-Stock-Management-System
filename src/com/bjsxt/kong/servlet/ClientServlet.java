package com.bjsxt.kong.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.kong.service.ClientService;
import com.bjsxt.kong.service.impl.ClientServiceImpl;
import com.bjsxt.pojo.Client;

@WebServlet("/insClient")
public class ClientServlet extends BaseServlet {
	// 创建实现类对象 调用方法
	private ClientService clientService = new ClientServiceImpl();
	/**
	 * 新增用户的方法
	 * 
	 * @throws IOException
	 */
	public void insClient(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 接收参数
		Client client = getParam(req);
		// 处理结果
		boolean flag = clientService.insClient(client);
		if (flag) {
			resp.getWriter().print(flag);
		}

	}

	private Client getParam(HttpServletRequest req) {
		// 创建对象 作为返回值
		Client client = new Client();
		client.setName(req.getParameter("name"));
		client.setAddress(req.getParameter("address"));
		client.setSname(req.getParameter("sname"));
		client.setZipcode(req.getParameter("zipcode"));
		client.setPhone(req.getParameter("phone"));
		client.setFax(req.getParameter("fax"));
		client.setContact(req.getParameter("contact"));
		client.setContactPhone(req.getParameter("contactPhone"));
		client.setEmail(req.getParameter("email"));
		client.setBank(req.getParameter("bank"));
		client.setAccountNumber(req.getParameter("accountNumber"));
		return client;
	}
}
