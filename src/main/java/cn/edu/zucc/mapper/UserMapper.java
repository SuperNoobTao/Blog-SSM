package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.pojo.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shentao on 2016/7/4.
 */

@Repository
public interface UserMapper {

    /**
     * 通过ID查询单个用户
     *
     * @param id
     * @return
     */
    TbUserEntity queryById(@Param("user_id")long id);

    /**
     * 通过acount查询单个用户
     * @param userAcount
     * @return
     */
    TbUserEntity queryByAcount(@Param("user_acount")String userAcount);

    /**
     * 查询在数据库里是否有此账号密码的用户
     * @param userAcount
     * @param pwd
     */
    TbUserEntity selectUser(@Param("user_acount")String userAcount, @Param("user_pwd")String pwd);

    /**
     * 在数据库中添加一个用户
     * @param user
     */
    int save(TbUserEntity user);

    /**
     * 保存用户的角色的对应关系
     * @param userId 用户Id
     * @param roleId 角色ID
     */
    int saveUserAndRole(@Param("user_id")int userId, @Param("role_id")int roleId);

    /**
     * 查询是否此账号的用户在数据库里
     * @param userAcount 用户账号
     */
    int countByAcount(@Param("user_acount")String userAcount);

    /**
     *  查询是否此email的用户在数据库里
     * @param userEmail 用户email
     */
    int countByEmail(@Param("user_email")String userEmail);






}
