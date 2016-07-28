package cn.edu.zucc.service;

import cn.edu.zucc.pojo.TbCommentEntity;
import cn.edu.zucc.pojo.TbGuestEntity;

import java.util.List;

/**
 * Created by shentao on 2016/7/17.
 */
public interface CommentService {

    /**
     * 得到所有留言
     * @return
     * @throws Exception
     */
    public List<TbCommentEntity> getAllComments() throws Exception;

}
