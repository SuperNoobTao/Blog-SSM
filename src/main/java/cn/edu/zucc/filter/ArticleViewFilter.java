package cn.edu.zucc.filter;


import cn.edu.zucc.service.ArticleService;
import cn.edu.zucc.util.TemplateUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**html静态化页面跳转
 * Created by shentao on 2016/6/12.
 */
public class ArticleViewFilter implements Filter {

    //获取模版填充所需信息

    ArticleService articleService ;

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }



    public static final String ARTICLE_VIEW_TOKEN = "view";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURL().toString();
        System.out.println("进入filter="+path);
        //模式匹配
        Pattern pattern = Pattern.compile("/blog/([0-9]+)/([0-9]+)-([0-9]+)");
        Matcher matcher = pattern.matcher(path);

        //不匹配，路径不正确
        if(!matcher.find()){
            //路径不对，报错404
            response.sendError(404,"您输入路径的不存在！");
            return;
        }
        //模版文件绝对路径
        String realPath = request.getServletContext().getRealPath("/");
        //文件路径
        String filePath = realPath+matcher.group()+".ftl";
        //查看服务器资源是否存在
        File file = new File(filePath);
        if(!file.exists()){
            //路径不对，报错404
            response.sendError(404,"您输入路径的不存在！");
            return;
        }
        //解析路径中的文章id
        int artid = Integer.parseInt(matcher.group(3));
        System.out.println("artid = "+artid);



        //防止同一用户session添加多次访问量
        boolean isNew = false;
        //获取当前用户session
        HttpSession session = request.getSession();
        //还没看过就能添加访问量
        if(session.getAttribute(ARTICLE_VIEW_TOKEN+artid)==null) {
            isNew = true;

            //设置当前的用户session已经看过文章了
            session.setAttribute(ARTICLE_VIEW_TOKEN+artid, "true");
        }

        //填充模版信息
        Map<String,Object> params = null;
        try {
            params = articleService.getTemplateParams(artid, request.getContextPath(),isNew);

        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean result =  TemplateUtils.parserTemplate(realPath+File.separator+"blog", matcher.group(1)+"/"+matcher.group(2)+"-"+matcher.group(3)+".ftl", params, response.getOutputStream());

        if(!result){
            //服务器异常
            response.sendError(500,"服务器未知异常！");
        }
        response.getOutputStream().close();
    }

    @Override
    public void destroy() {

    }
}
