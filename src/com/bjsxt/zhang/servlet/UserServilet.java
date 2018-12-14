package com.bjsxt.zhang.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.User;
import com.bjsxt.zhang.service.UserService;
import com.bjsxt.zhang.service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServilet extends BaseServlet {

	private UserService userService = new UserServiceImpl();

	public void insUser(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 接收参数
		System.out.println("servlet测试：" + req.getParameter("roleId_1"));
		User user = getParam(req);
		resp.getWriter().print(userService.insUser(user));

	}

	private User getParam(HttpServletRequest req) {
		User user = new User();
		String id = req.getParameter("id");
		if (id != null) {
			user.setId(Integer.parseInt(id));
		}
		user.setName(req.getParameter("name"));
		user.setRname(req.getParameter("rname"));
		user.setPwd(req.getParameter("pwd"));
		String roleId = req.getParameter("roleId_1");
		if (roleId != null) {
			user.setRoleId(Integer.parseInt(roleId));
		}
		System.out.println("测试user数据：" + user.toString());

		return user;
	}

	public void updUser(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 接收参数
		int id = Integer.parseInt(req.getParameter("id"));
		String opwd = req.getParameter("opwd");
		String npwd = req.getParameter("npwd");
		// 直接响应
		resp.getWriter().print(userService.updPwd(id, opwd, npwd));

	}
}
