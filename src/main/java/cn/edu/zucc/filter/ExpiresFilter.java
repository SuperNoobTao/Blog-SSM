package cn.edu.zucc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制静态资源浏览器进行缓存的过滤器
 *
 * @author 宇强
 *
 */
public class ExpiresFilter implements Filter {

	/**
	 * 过滤器配置参数
	 */
	private FilterConfig config;

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
						 FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 1.获取想访问的资源
		String uri = request.getRequestURI();
		// 2.得到想访问资源的后缀名
		String ext = uri.substring(uri.lastIndexOf(".") + 1);
		// 3.得到资源要缓存的时间
		String time = config.getInitParameter(ext);
		//为空则不设置
		if (time != null && !time.trim().equals("")) {
			//如果设置的参数不是int类型，也不设置
			try{
				int t = Integer.parseInt(time);
				response.setDateHeader("expires", System.currentTimeMillis() + t * 3600 * 1000);
			}catch (Exception e) {

			}
		}
		//放行
		chain.doFilter(request, response);
	}

	/* 获取初始化参数
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}

}
