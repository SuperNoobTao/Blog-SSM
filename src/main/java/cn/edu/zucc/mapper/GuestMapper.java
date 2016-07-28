package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.pojo.TbGuestEntity;
import cn.edu.zucc.pojo.TbUserEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by shentao on 2016/7/17.
 */
public interface GuestMapper {

    /**
     * 查找所有的客户
     * @param
     * @return
     * @throws Exception
     */
    public List<TbGuestEntity> findAll() throws Exception;

    //查询单个
    TbGuestEntity queryGuestByEmail(String email) throws SQLException;

    int save(TbGuestEntity guest);
}
