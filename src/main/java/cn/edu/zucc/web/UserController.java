package cn.edu.zucc.web;

import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by shentao on 2016/7/5.
 */
@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String login(@Valid TbUserEntity tbUserEntity, Model model, BindingResult bindingResult, HttpSession httpSession) {

        tbUserEntity = userService.login(tbUserEntity.getUserAcount(),tbUserEntity.getUserPwd());

        if (tbUserEntity != null) {
            model.addAttribute("beanadminEntity", tbUserEntity);
            httpSession.setAttribute("beanadminEntity", tbUserEntity);
            return "list";
        }
        return null;
    }


}
