package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.CommentMapper;
import cn.edu.zucc.pojo.TbCommentEntity;
import cn.edu.zucc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shentao on 2016/7/17.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<TbCommentEntity> getAllComments() throws Exception {
        return commentMapper.findAll();
    }
}
