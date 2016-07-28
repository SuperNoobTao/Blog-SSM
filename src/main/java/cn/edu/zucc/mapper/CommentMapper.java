package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.pojo.TbCommentEntity;
import cn.edu.zucc.pojo.TbGuestEntity;

import java.util.List;

/**
 * Created by shentao on 2016/7/17.
 */
public interface CommentMapper {
    /**
     * 查找所有的评论
     * @param
     * @return
     * @throws Exception
     */
    public List<TbCommentEntity> findAll() throws Exception;

    int save(TbCommentEntity com);


}
