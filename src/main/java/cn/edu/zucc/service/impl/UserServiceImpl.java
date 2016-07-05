package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.UserMapper;
import cn.edu.zucc.entity.TbUserEntity;
import cn.edu.zucc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shentao on 2016/7/5.
 */

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private UserMapper userMapper;

    @Override
    public TbUserEntity getById(long userId) {
        return userMapper.queryById(userId);
    }

    @Override
    public TbUserEntity getByName(String userAcount) {
        return userMapper.queryByName(userAcount);
    }


}
