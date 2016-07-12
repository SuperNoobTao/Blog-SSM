package cn.edu.zucc.web;

import cn.edu.zucc.dto.Result;
import cn.edu.zucc.dto.Message;
import cn.edu.zucc.enums.StateEnum;
import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.service.UserService;


import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.util.SystemOutLogger;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.List;
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

    @Value("${user.salt}")
    private String passwordSalt;

    /**
     * 登录页
     */
    @RequestMapping(value = "/loginui", method = RequestMethod.GET)
    public String login() {
        logger.info("/page/loginui");
        return "login";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
        private String login(@Valid TbUserEntity tbUserEntity,RedirectAttributes redirectAttributes) {
        //获取认证主体，如果主体已存在，则将当前的主体退出
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            return "redirect:/process/Jurisdiction";
        }

        if(subject.isAuthenticated()) {
            subject.logout();
        }

        try {
            //登录，调用ShiroRealm类中的登录认证方法
            subject.login(new UsernamePasswordToken(tbUserEntity.getUserAcount(), DigestUtils.md5Hex(tbUserEntity.getUserPwd()+passwordSalt)));

            System.out.println(passwordSalt);
            System.out.println(tbUserEntity.getUserAcount());
            System.out.println(DigestUtils.md5Hex(tbUserEntity.getUserPwd()+passwordSalt));
            //将登录的对象放入到Session中
            Session session = subject.getSession();
            session.setAttribute(tbUserEntity.SESSION_KEY,(TbUserEntity)subject.getPrincipal());
            System.out.println((TbUserEntity)subject.getPrincipal());
            return "redirect:/process/Jurisdiction";
        } catch (LockedAccountException ex) {
            redirectAttributes.addFlashAttribute("message",new Message(StateEnum.ERROR,ex.getMessage()));
            return "redirect:/";
        } catch (UnknownAccountException ex) {
            redirectAttributes.addFlashAttribute("message",new Message(StateEnum.ERROR,ex.getMessage()));
            return "redirect:/";
        } catch (AuthenticationException ex) {
            redirectAttributes.addFlashAttribute("message",new Message(StateEnum.ERROR,"账号或密码错误"));
            return "redirect:/";
        }


    }


    @RequestMapping(value = "/register/checkUserName", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
        private String checkUserName(@Valid TbUserEntity tbUserEntity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAcount=tbUserEntity.getUserAcount();
        System.out.println(userAcount);
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

    @RequestMapping(value = "/register/checkEmail", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    private String checkEmail(@Valid TbUserEntity tbUserEntity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("进入controller");
        String userEmail=(String)request.getParameter("userEmail");
        System.out.println(userEmail);
        int num = userService.countByEmail(userEmail);
        //邮箱是否存在的标志
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

    @RequestMapping(value = "/register/checkUserRegister", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    private String checkUserRegister( HttpServletRequest request, HttpServletResponse response,TbUserEntity tbUserEntity) throws IOException {

        TbUserEntity user =new TbUserEntity();
        user.setUserEmail(request.getParameter("userEmail"));
        user.setUserAcount(request.getParameter("userAcount"));
        user.setUserPwd(request.getParameter("userPwd"));
        user.setUserPhone(request.getParameter("userPhone"));
        user.setUserName(request.getParameter("userName"));

        int num = userService.saveNewUser(user,3);
        System.out.println("num为？大于0说明添加成功="+num);
        //邮箱是否存在的标志
        boolean flag=false;

        if(num>0){
            flag=true;
        }
        //将数据转换成json
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("flag", flag);
        System.out.println("flag是"+flag);
        String json = JSONObject.valueToString(map).toString();
        System.out.println(json);
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;

    }





}
