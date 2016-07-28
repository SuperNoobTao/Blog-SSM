package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.GuestMapper;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.pojo.TbGuestEntity;
import cn.edu.zucc.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shentao on 2016/7/17.
 */
@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestMapper guestMapper;


    @Override
    public List<TbGuestEntity> getAllGuests() throws Exception {
        return guestMapper.findAll();
    }
}
