package cn.edu.zucc.web.AdminController;

import cn.edu.zucc.util.RoleSign;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by shentao on 2016/7/10.
 */
@Controller
@RequestMapping("/admin") // url:/模块/资源/{id}/细分 /seckill/list
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 管理员首页
     *
     * @return "admin/main"
     */
    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String mainGet(Model model, HttpSession httpSession) {
        logger.info("/admin/main");

        return "admin/main";
    }


}
