package test.cn.edu.zucc.mapper;

import cn.edu.zucc.mapper.CommentMapper;
import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.pojo.TbCommentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by shentao on 2016/7/17.
 */




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mapper.xml"})
public class CommentMapperTest {


    @Autowired
    private CommentMapper commentMapper;



    @Test
    public void testFindAll() throws Exception {
        List<TbCommentEntity> commentEntities =commentMapper.findAll();
        for (int i = 0 ;i<commentEntities.size() ;i++) {
        System.out.println(commentEntities.get(i).getTbGuestEntity().getGuestName());
       // System.out.println(commentEntities.get(i).getTbGuestEntity().getGuestName());
    }
}



}
