package cn.edu.zucc.util;

import cn.edu.zucc.pojo.TbUserEntity;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    /**
     * 判断当前是否登录状态
     * @return
     */
    public static boolean isCurrentUser(){
        return getCurrentUser() != null;
    }


    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 查询当前登录者信息
     * @return ShiroUser
     */
    public static TbUserEntity getCurrentUser() {
        return  (TbUserEntity) getSubject().getPrincipal();
    }

    /**
     * 判断当前用户是否是管理员
     * @return
     */
    public static boolean isAdmin () {
        return getSubject().hasRole("管理员");
    }

    /**
     * 判断当前用户是否是编辑员
     * @return
     */
    public static boolean isManager() {
        return getSubject().hasRole("编辑员");
    }

    /**
     * 判断当前用户是否是普通游客
     * @return
     */
    public static boolean isEmployee() {
        return getSubject().hasRole("游客");
    }



    /**
     * 查询当前登录者 用户名
     * @return
     */
    public static String getCurrentUserName() {
        return getCurrentUser().getUserName();
    }
    /**
     * 查询当前登录者 用户Id
     * @return
     */
    public static Integer getCurrentUserId() {
        return getCurrentUser().getUserId();
    }

}
