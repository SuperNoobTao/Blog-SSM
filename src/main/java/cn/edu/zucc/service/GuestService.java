package cn.edu.zucc.service;

import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.pojo.TbGuestEntity;

import java.util.List;

/**
 * Created by shentao on 2016/7/17.
 */
public interface GuestService {
    /**
     * 得到所有游客
     * @return
     * @throws Exception
     */
    public List<TbGuestEntity> getAllGuests() throws Exception;

}
