package cn.edu.zucc.web;

import cn.edu.zucc.dto.Result;
import cn.edu.zucc.dto.Message;
import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.service.UserService;


import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shentao on 2016/7/5.
 */
@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
        private String login(@Valid TbUserEntity tbUserEntity,RedirectAttributes redirectAttributes) {
        //获取认证主体，如果主体已存在，则将当前的主体退出
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        return "";

    }
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    private String register(@Valid TbUserEntity tbUserEntity, Model model, BindingResult bindingResult, HttpSession httpSession) {

        userService.saveNewUser(tbUserEntity,3);

        return "";
    }

    @RequestMapping(value = "/register/checkUserName", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
        private String checkUserName(@Valid TbUserEntity tbUserEntity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAcount=tbUserEntity.getUserAcount();
        int num = userService.countByAcount(userAcount);
        //用户名是否存在的标志
        boolean flag=false;
        if(num>0){
            flag=true;
        }
        //将数据转换成json
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("flag", flag);
        String json = JSONObject.valueToString(map).toString();
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;

    }



}
