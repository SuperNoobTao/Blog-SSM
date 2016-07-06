package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.RoleMapper;
import cn.edu.zucc.mapper.UserMapper;
import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shentao on 2016/7/6.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public TbRoleEntity getByUserId(int userId) {
        return roleMapper.QueryByUserId(userId);
    }
}
