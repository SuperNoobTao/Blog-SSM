package cn.edu.zucc.web.AdminController;

import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.pojo.TbUserEntity;
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

/**
 * Created by shentao on 2016/7/10.
 */

@Controller
@RequestMapping("/admin/category") // url:/模块/资源/{id}/细分 /seckill/list
public class CategoryController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    public String create(@Valid TbCategoryEntity tbCategoryEntity, HttpServletRequest request, Model model, HttpSession httpSession)  {
        logger.info("/admin/category/create");
        try {
        System.out.println(tbCategoryEntity.getCategoryName());
        System.out.println(tbCategoryEntity.getCategoryRemark());
            categoryService.addCategory(tbCategoryEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/category" ;
    }


    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String update(@Valid TbCategoryEntity tbCategoryEntity, HttpServletRequest request, Model model, HttpSession httpSession)  {

        System.out.println(tbCategoryEntity.getCategoryName());
        System.out.println(tbCategoryEntity.getCategoryRemark());
        try {
            categoryService.updateCategory(tbCategoryEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/category" ;
    }



    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String delete(@Valid TbCategoryEntity tbCategoryEntity, HttpServletRequest request, Model model, HttpSession httpSession)  {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        System.out.println(categoryId);
        try {
            categoryService.deleteCategory(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/category" ;
    }







}
