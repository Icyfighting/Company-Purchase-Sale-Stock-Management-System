package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.User;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 获取用户的访问路径
		String uri = req.getRequestURI();
		if (uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".jpg")
				|| uri.endsWith(".png") || uri.endsWith(".gif")
				|| uri.contains("index.jsp")
				|| uri.equalsIgnoreCase(req.getContextPath() + "/login")) {
			chain.doFilter(req, resp);
		} else {
			// 获取session中的users
			User user = (User) req.getSession().getAttribute("user");
			if (user != null) {// 已经登录
				chain.doFilter(req, resp);
			} else {// 没有登录
				req.getSession().setAttribute("msg", "请您先登录!");
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			}
		}
	}

	@Override
	public void destroy() {
	}

}
