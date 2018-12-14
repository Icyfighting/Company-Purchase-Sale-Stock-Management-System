/**
 * @Title:BaseServlet.java 
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
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title:BaseServlet 
 * @Description:TODO
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @data 2018年3月14日
 */
public abstract class BaseServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		// 接收需要被调用的方法名称
		String method = req.getParameter("method");
		try {
			// 获取被调用方法的Method对象
			Method fn = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			// 调用方法
			fn.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
