package com.bjsxt.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Role;
import com.bjsxt.zhang.service.RoleService;
import com.bjsxt.zhang.service.impl.RoleServiceImpl;
import com.google.gson.Gson;

@WebServlet("/role")
public class RoleServlet extends BaseServlet {

	private RoleService roleService = new RoleServiceImpl();

	public void selRole(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Role> list = roleService.selRole();
		req.getSession().setAttribute("list", list);
		resp.setContentType("application/json;charset=UTF-8");
		resp.getWriter().print(new Gson().toJson(list));

	}

}
