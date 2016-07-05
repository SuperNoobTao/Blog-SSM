package cn.edu.zucc.mapper;

import cn.edu.zucc.entity.TbUserEntity;

/**
 * Created by shentao on 2016/7/4.
 */


public interface UserMapper {

    /**
     * 通过ID查询单个用户
     *
     * @param id
     * @return
     */
    TbUserEntity queryById(long id);


    /**
     * 通过name查询单个用户
     * @param userAcount
     * @return
     */
    TbUserEntity queryByName(String userAcount);

}
