package cn.edu.zucc.web.AdminController;

import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.util.RoleSign;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.SerializeUtils;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;
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
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 管理员首页
     * @return "admin/main"
     */
    @RequestMapping(value = "/admin", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String mainGet(Model model, HttpSession httpSession) {
        logger.info("/admin");
//        String key = TbUserEntity.SESSION_KEY;
//        RedisManager redisManager  = new RedisManager();
//        Subject currentUser = SecurityUtils.getSubject();
//        Session session = currentUser.getSession();
//        TbUserEntity user = (TbUserEntity) session.getAttribute(key);
//        byte[] obj = redisManager.get(key.getBytes());
//        if (obj != null) {
//            TbUserEntity userInRedis = (TbUserEntity) SerializeUtils.deserialize(obj);
//        }else{
//        logger.info("redis缓存中并无此数据");
//        redisManager.set(key.getBytes(), SerializeUtils.serialize(user));}
        return "admin/main";
    }


}
