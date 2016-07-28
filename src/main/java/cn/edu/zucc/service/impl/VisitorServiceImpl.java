package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.ArticleMapper;
import cn.edu.zucc.mapper.CommentMapper;
import cn.edu.zucc.mapper.GuestMapper;
import cn.edu.zucc.pojo.TbCommentEntity;
import cn.edu.zucc.pojo.TbGuestEntity;
import cn.edu.zucc.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shentao on 2016/7/17.
 */
@Service
public class VisitorServiceImpl implements VisitorService{


    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private GuestMapper guestMapper;


    @Override
    public long addGuest(TbGuestEntity guest) throws Exception {
        TbGuestEntity g = guestMapper.queryGuestByEmail(guest.getGuestEmail());
        guestMapper.save(g);

        return g.getGuestId();
    }

    @Override
    public void addComment(TbGuestEntity guest, TbCommentEntity comment, String contextPath) throws Exception {
        commentMapper.save(comment);
    }
}
