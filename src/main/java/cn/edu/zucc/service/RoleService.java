package cn.edu.zucc.service;

import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.pojo.TbUserEntity;

/**
 * Created by shentao on 2016/7/6.
 */
public interface RoleService {


    /**
     * 查询一个用户的角色
     *
     * @param userId
     * @return
     */
    TbRoleEntity getByUserId(int userId);

}
