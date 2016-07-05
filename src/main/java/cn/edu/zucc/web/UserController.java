package cn.edu.zucc.web;

import cn.edu.zucc.entity.TbUserEntity;
import cn.edu.zucc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by shentao on 2016/7/5.
 */
@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String login(Model model) {
        TbUserEntity tbUserEntity = userService.getById(32);
        model.addAttribute("list", tbUserEntity);
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }


}
