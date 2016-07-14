package cn.edu.zucc.filter.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * HttpServletRequest增强的包装类
 *
 * Created by shentao on 2016/6/12.
 *
 */

public class EncodingRequest extends HttpServletRequestWrapper {

	/**
	 * 要包装的request
	 */
	private HttpServletRequest request;

	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		try {
			String value = this.request.getParameter(name);
			//空值直接返回
			if (value == null)
				return value;
			//不是get方法不需要处理
			if (!this.request.getMethod().equalsIgnoreCase("get"))
				return value;

			//get方法的把编码改成设置的编码格式，解决get方式参数的中文乱码问题
			value = new String(value.getBytes("ISO8859-1"),
					this.request.getCharacterEncoding());
			return value;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
