package cn.edu.zucc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by shentao on 2016/7/12.
 * 去掉url中的jsessionid 信息
 */

public class DisableUrlSessionFilter implements Filter{

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // skip non-http requests
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // clear session if session id in URL
        if (httpRequest.isRequestedSessionIdFromURL()) {
            HttpSession session = httpRequest.getSession();
            if (session != null) session.invalidate();
        }

        // wrap response to remove URL encoding
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
            @Override
            public String encodeRedirectUrl(String url) {
                return url;
            }


            public String encodeRedirectURL(String url) {
                return url;
            }


            public String encodeUrl(String url) {
                return url;
            }


            public String encodeURL(String url) {
                return url;
            }
        };

        // process next request in chain
        chain.doFilter(request, wrappedResponse);
    }

    /**
     * Unused.
     */
    public void init(FilterConfig config) throws ServletException {
    }

    /**
     * Unused.
     */
    public void destroy() {
    }
}