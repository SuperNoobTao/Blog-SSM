package cn.edu.zucc.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shentao on 2016/7/10.
 */

@Controller
@RequestMapping("/process") // url:/模块/资源/{id}/细分 /seckill/list
public class ProcessController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/Jurisdiction")//权限的管理
    public String jurisdiction() {
        logger.info("/process/Jurisdiction");
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("admin"))
            return "redirect:/admin";
        else if(subject.hasRole("editor"))
            return "redirect:/editor/main";
        else if(subject.hasRole("guest"))
            return "redirect:/guest/main";

        return "login";

    }



}
