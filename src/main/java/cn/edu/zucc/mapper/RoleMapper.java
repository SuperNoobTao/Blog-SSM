package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbRoleEntity;


import java.util.List;

public interface RoleMapper {
    /**
     * 根据用户ID查找具有的角色列表
     * @param userId
     * @return
     */
    TbRoleEntity QueryByUserId(Integer userId);


}
