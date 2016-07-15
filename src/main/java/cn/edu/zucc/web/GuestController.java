package cn.edu.zucc.web;

import cn.edu.zucc.mapper.ArticleMapper;
import cn.edu.zucc.service.ArticleService;
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
import java.util.Map;

/**
 * Created by shentao on 2016/7/10.
 */

@Controller
@RequestMapping("/guest") // url:/模块/资源/{id}/细分 /seckill/list
public class GuestController {

    @Autowired
    private ArticleService articleService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 游客首页
     *
     * @return "editor/main"
     */
    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.GUEST)
    public String mainGet(Model model, HttpSession httpSession,HttpServletRequest request) {
        logger.info("/guest/main");
        try {
            Map<String,Object> params = articleService.getArticleListParams(request.getContextPath());
            model.addAttribute("params",params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "guest/main";
    }




}
