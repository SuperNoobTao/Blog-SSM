package cn.edu.zucc.web.AdminController;

import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.service.ArticleService;
import cn.edu.zucc.service.CategoryService;
import cn.edu.zucc.util.RoleSign;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;

/**
 * Created by shentao on 2016/7/10.
 */
@Controller
@RequestMapping("/admin/article") // url:/模块/资源/{id}/细分 /seckill/list
public class ArticleController {
    @Autowired
    private ArticleService articleService ;
    private CategoryService categoryService;
    private String method;
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String create(@Valid TbArticleEntity tbArticleEntity, HttpServletRequest request,Model model, HttpSession httpSession) throws Exception {

        TbUserEntity user = (TbUserEntity) httpSession.getAttribute("curr_user");

        TbArticleEntity article = initAddArticle(tbArticleEntity);
        article.setUserId(user.getUserId());
        article.setArticleAuthor(user.getUserName());
        //保存博文
        articleService.addArticle(article, request.getContextPath(), request.getServletContext().getRealPath("/blog"));
        request.setAttribute("message", "博文录入成功！！！");
        request.setAttribute("url", request.getContextPath() + "/article");

        return "redirect:/" ;
    }

    //初始化封装文章实体
    private TbArticleEntity initAddArticle(TbArticleEntity tbArticleEntity) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        TbArticleEntity article = new TbArticleEntity();
        article.setCategoryId(tbArticleEntity.getCategoryId());
        article.setArticleCdate(now);
        article.setArticleTitle(tbArticleEntity.getArticleTitle());
        article.setArticleType(tbArticleEntity.getArticleType());
        article.setArticleTop(tbArticleEntity.getArticleTop());

        System.out.println("categoryId=" + tbArticleEntity.getCategoryId());
        System.out.println("cdate=" + now);
        System.out.println("articleTitle=" + tbArticleEntity.getArticleTitle());
        System.out.println("articleType=" + tbArticleEntity.getArticleType());
        System.out.println("articleTop=" + tbArticleEntity.getArticleTop());
        System.out.println("articleMeta=" + tbArticleEntity.getArticleMeta());


        //截取正文部分
        String content = tbArticleEntity.getArticleContent();
        System.out.println(content);
        content = content.substring(content.indexOf("<body>") + 6);
        content = content.substring(0, content.indexOf("</body>"));
        article.setArticleContent(content);
        //提取文章摘要
        if (content.length() > 250) {
            int start = content.indexOf("<span style=\"font-family:") + 25;
            String meta = content.substring(start, start + 220);
            meta = meta.substring(meta.indexOf(">") + 1);
            meta = "<span style=\"font-family:微软雅黑;\">" + meta + "</span>";
            article.setArticleMeta(meta);
        } else article.setArticleMeta(content);
        return article;
    }


}
