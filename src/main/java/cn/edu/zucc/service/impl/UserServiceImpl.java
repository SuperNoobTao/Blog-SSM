package cn.edu.zucc.service.impl;

import cn.edu.zucc.dto.Message;
import cn.edu.zucc.mapper.UserMapper;
import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by shentao on 2016/7/5.
 */

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private UserMapper userMapper;
    @Value("${user.salt}")
    private String passwordSalt;

    @Override
    public TbUserEntity getById(long userId) {
        return userMapper.queryById(userId);
    }

    @Override
    public TbUserEntity getByName(String userAcount) {
        return userMapper.queryByAcount(userAcount);
    }

    @Override
    public Message login(String userAcount, String userPwd) {
        return null;
    }

    /**
     * 保存新用户
     * @param user
     * @param roleId
     */
    @Override
    @Transactional
    public int saveNewUser(TbUserEntity user, int roleId) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setUserPwd(DigestUtils.md5Hex(user.getUserPwd()+passwordSalt));
        user.setUserState(user.USER_STATE_OK);
        user.setUserCdate(now);
        user.setUserSex("男");
        int i = userMapper.save(user);
        System.out.println("增加后的Id="+user.getUserId());
        //保存用户的角色的关系
        userMapper.saveUserAndRole(user.getUserId(),roleId);
        return  i;
    }

    @Override
    public int countByAcount(String userAcount) {
        return userMapper.countByAcount(userAcount);
    }

    @Override
    public int countByEmail(String userEmail) {
        return userMapper.countByEmail(userEmail);
    }









}
