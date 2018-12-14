package com.bjsxt.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter(value="/*", initParams=@WebInitParam(description="encoding", name="encoding", value="UTF-8"))
public class CharsetFilter implements Filter {

	// 编码方式
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取初始化参数
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding);
		// 强转
		HttpServletRequest req = (HttpServletRequest) request;
		// 获取请求方式
		String method = req.getMethod();
		// 如果是get方式, 重写getParameter方法, 解决乱码
		if("get".equalsIgnoreCase(method)) {
			req = new HttpServletRequestWrapper(req) {
				@Override
				public String getParameter(String name) {
					String value = super.getParameter(name);
					try {
						if(value != null && value.length() > 0) {
							// 使用iso-8859-1解码
							byte[] bytes = value.getBytes("ISO-8859-1");
							// 使用utf-8编码
							return new String(bytes, encoding);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					return value;
				}
			};
		}
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}

}
