package cn.edu.zucc.web;

import cn.edu.zucc.util.RoleSign;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by shentao on 2016/7/10.
 */

@Controller
@RequestMapping("/guest") // url:/模块/资源/{id}/细分 /seckill/list
public class GuestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 游客首页
     *
     * @return "editor/main"
     */
    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.GUEST)
    public String mainGet(Model model, HttpSession httpSession) {
        logger.info("/guest/main");

        return "guest/main";
    }
}
