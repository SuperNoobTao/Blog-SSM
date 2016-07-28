package cn.edu.zucc.web;

import cn.edu.zucc.pojo.*;
import cn.edu.zucc.service.ArticleService;
import cn.edu.zucc.service.CategoryService;
import cn.edu.zucc.service.CommentService;
import cn.edu.zucc.service.GuestService;
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
import java.util.List;

/**
 * Created by shentao on 2016/7/15.
 */
@Controller
public class PageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private GuestService guestService;
    @Autowired
    private CommentService commentService;



    /**
     * 注销
     * @param model
     * @param httpSession
     * @return "admin/article"
     */
    @RequestMapping(value = "/quit", method = {RequestMethod.GET, RequestMethod.POST})
    public String quit(Model model, HttpSession httpSession) {
        logger.info("/quit");
        httpSession.removeAttribute("curr_user");
        return "redirect:/user/loginui";
    }





    /**
     * 文章管理页面
     * @param model
     * @param httpSession
     * @return "admin/article"
     */
    @RequestMapping(value = "/admin/article", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String article(Model model, HttpSession httpSession) {
        logger.info("/admin/article");
        List<TbArticleEntity> articleList = null;
        try {
            articleList = articleService.getAllArtcles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("page", articleList);
        return "admin/admin-article-manage";
    }

    /**
     * 类别管理页面
     * @param model
     * @param httpSession
     * @return "admin/category"
     */
    @RequestMapping(value = "/admin/category", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String category(Model model, String pagenum,HttpSession httpSession,HttpServletRequest request) {
        logger.info("/admin/category");
        try {
            String url = request.getContextPath()+"/admin/category";
            Page<TbCategoryEntity> page = categoryService.queryPageCategory(pagenum,url);
            System.out.println("目前是"+pagenum);
            model.addAttribute("page",page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/admin-category-manage";
    }



    /**
     * 类别添加页面
     * @param model
     * @param httpSession
     * @return "admin/category"
     */
    @RequestMapping(value = "/admin/category/createUI", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String categoryCreate(Model model, HttpSession httpSession, HttpServletRequest request) {
        logger.info("/admin/category/createUI");
        request.setAttribute("method","create");

        return "admin/admin-category";
    }

    /**
     * 类别修改页面
     * @param model
     * @param httpSession
     * @return "admin/category"
     */
    @RequestMapping(value = "/admin/category/editUI", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String categoryEdit(Model model, HttpSession httpSession, HttpServletRequest request) {
        logger.info("/admin/category/editUI");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        System.out.println(categoryId);
        try {
            TbCategoryEntity tbCategoryEntity = categoryService.queryCategory(categoryId);

            model.addAttribute("category",tbCategoryEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("method","update");
        return "admin/admin-category";
    }


    /**
     * 游客管理页面
     * @param model
     * @param httpSession
     * @return "admin/guest"
     */
    @RequestMapping(value = "/admin/guest", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String guest(Model model, HttpSession httpSession) {
        logger.info("/admin/guest");
        List<TbGuestEntity> guestList = null;
        try {
            guestList = guestService.getAllGuests();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("page",guestList);
        return "admin/admin-guest-manage";
    }



    /**
     * 留言管理页面
     * @param model
     * @param httpSession
     * @return "admin/guest"
     */
    @RequestMapping(value = "/admin/comment", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String comment(Model model, HttpSession httpSession) {
        logger.info("/admin/comment");
        List<TbCommentEntity> commentList = null;
        try {
            commentList = commentService.getAllComments();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("page",commentList);
        return "admin/admin-comment-manage";
    }

    /**
     * 个人资料管理页面
     * @param model
     * @param httpSession
     * @return "admin/user/edit"
     */
    @RequestMapping(value = "/admin/user/edit", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String user(Model model, HttpSession httpSession) {
        logger.info("/admin/user/edit");
        return "admin/admin-user-manage";
    }



    /**
     * 文章添加页面
     * @return "admin/article/create"
     */
    @RequestMapping(value = "/admin/article/createUI", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String article_add(Model model, HttpSession httpSession,HttpServletRequest request) {
        List<TbCategoryEntity> categories = null;
        try {
            categories = categoryService.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("categories", categories);
        request.setAttribute("method", "add");
        request.setAttribute("pageTitle", "添加文章");
        logger.info("/admin/article");
        return "admin/admin-article";
    }


    /**
     * 文章修改页面
     * @return "admin/article/edit"
     */
    @RequestMapping(value = "/admin/article/edit", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String article_update(Model model, HttpSession httpSession) {
        logger.info("/admin/article");
        return "";
    }

    /**
     * 留言页面
     * @return "guest/comment"
     */
    @RequestMapping(value = "/guest/comment/add", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String comment_addUI(Model model, HttpSession httpSession) {
        logger.info("/guest/comment");
        return "/guest/comment";
    }



}
