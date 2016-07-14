package cn.edu.zucc.util;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by shentao on 2016/6/12.
 */
public class WebUtils {

	/**格式化日期
	 * @param date
	 * @return
	 */
	public static String toDateString(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	/**格式化日期和时分
	 * @param date
	 * @return
	 */
	public static String toDateTimeString(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return format.format(date);
	}
	/**
	 * 将request中的数据封装到javabean中
	 *
	 * @param request
	 * @param clazz 要合成的JavaBean类
	 * @return 返回合成好的JavaBean对象
	 */
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
		try {
			// 创建Bean
			T t = clazz.newInstance();
			// 将Request中的数据填充到Bean
			Enumeration enumeration = request.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String name = (String) enumeration.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(t, name, value);
			}
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将一个javabean中的数据复制到另一种类的javabean，通过属性名对应
	 *
	 * @param src 源Bean
	 * @param dest 目标Bean
	 */
	public static void copyBean(Object src, Object dest) {

		// 设置Date类型的转换器
		ConvertUtils.register(new Converter() {

			public Object convert(Class type, Object value) {
				if (value == null)
					return null;
				String str = (String) value;
				if (str.trim().equals("") || str.trim().equals("null"))
					return null;
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					return format.parse(str);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
