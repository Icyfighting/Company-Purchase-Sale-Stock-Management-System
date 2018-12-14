package com.bjsxt.yanbing.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基础Servlet, 被所有Servlet继承 用于根据不同请求调用对应的方法
 * 
 * @author Administrator
 * 
 */
public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		// 接收需要被调用的方法名称
		String method = req.getParameter("method");
		try {
			// 获取被调用方法的Method对象
			Method fn = this.getClass().getMethod(method,
					HttpServletRequest.class, HttpServletResponse.class);
			// 调用方法
			fn.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
