package cn.edu.zucc.filter;


import cn.edu.zucc.filter.support.EncodingRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 解决全站Post请求中文乱码问题过滤器
 *
 * Created by shentao on 2016/6/12.
 *
 */
public class CharacterEncodingFilter implements Filter {

	/**
	 * 初始化参数
	 */
	private FilterConfig config;
	/**
	 * 默认编码字符集
	 */
	private String defaultCharset = "UTF-8";

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
						 FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 获取设置的编码集
		String charset = config.getInitParameter("charset");
		// 为空选择设置默认编码集
		if (charset == null || charset.trim().equals(""))
			charset = defaultCharset;
		else {
			// 检查初始化参数中设置的编码集字符串是否合法
			try {
				Charset.forName(charset);
			} catch (Exception e) {
				// 不合法直接使用默认编码字符集
				charset = defaultCharset;
			}
		}
		// 设置默认编码字符集
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);
		// 放行，返回解决get中文乱码的包装类request
		chain.doFilter(new EncodingRequest(request), response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取初始化参数
		this.config = filterConfig;
	}

}
