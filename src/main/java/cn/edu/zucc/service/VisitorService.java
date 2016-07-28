package cn.edu.zucc.service;

import cn.edu.zucc.pojo.TbCommentEntity;
import cn.edu.zucc.pojo.TbGuestEntity;

/**
 * Created by shentao on 2016/7/17.
 */
public interface VisitorService {
    //添加客户，留言的时候自动记录客户
    public long addGuest(TbGuestEntity guest) throws Exception;
    //添加留言
    public void addComment(TbGuestEntity guest, TbCommentEntity comment, String contextPath) throws Exception;
}
