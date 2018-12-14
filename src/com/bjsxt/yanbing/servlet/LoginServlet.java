package com.bjsxt.yanbing.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;
import com.bjsxt.yanbing.service.UserService;
import com.bjsxt.yanbing.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
	private UserService userService = new UserServiceImpl();

	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接收用户信息
		String uname = req.getParameter("uname");
		String upwd = req.getParameter("upwd");
		// 调用service方法
		Map<String, Object> map = userService.login(uname, upwd);
		User user = (User) map.get("user");
		List<Menu> menus = (List<Menu>) map.get("menus");
		if (user != null) {
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("menus", menus);
			resp.sendRedirect(req.getContextPath() + "/main.jsp");
		} else {
			req.getSession().setAttribute("msg", "用户名或密码不正确");
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}
	}

	public void quit(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

	public void updPwd(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 接收参数
		int id = Integer.parseInt(req.getParameter("id"));
		String opwd = req.getParameter("opwd");
		String npwd = req.getParameter("npwd");
		System.out.println("id:" + id);
		System.out.println("opwd:" + opwd);
		System.out.println("npwd" + npwd);
		// 直接响应
		resp.getWriter().print(userService.updPwd(id, opwd, npwd));
	}
}
