package cn.edu.zucc.service;

import cn.edu.zucc.dto.Message;
import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.pojo.TbUserEntity;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by shentao on 2016/7/5.
 */
public interface UserService {
    /**
     * 查询一个用户
     *
     * @param userId
     * @return
     */
    TbUserEntity getById(long userId);


    /**
     * 查询一个用户by Acount
     *
     * @param userAcount
     * @return
     */
    TbUserEntity getByName(String userAcount);


    /**
     * 登录
     * @param userAcount
     * @param userPwd
     * @return
     */
    Message login(String userAcount, String userPwd);


    /**
     * 保存新用户
     * @param user
     * @param roleId
     */

    public void saveNewUser(TbUserEntity user, int roleId);




}

