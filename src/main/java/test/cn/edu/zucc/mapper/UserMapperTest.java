package test.cn.edu.zucc.mapper;

/**
 * Created by shentao on 2016/7/5.
 */

import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shentao on 2016/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mapper.xml"})
public class UserMapperTest{

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testQueryById() throws Exception {
        long userId = 32;
        TbUserEntity user = userMapper.queryById(userId);
        System.out.println(user);
    }
    @Test
    public void testQueryByAcount() throws Exception {
        String userAcount = "1";
        TbUserEntity user = userMapper.queryByAcount(userAcount);
        System.out.println(user);
    }

    @Test
    public void testSelectUser() throws Exception {
        String userAcount = "1";
        String pwd = "1";
        TbUserEntity user = userMapper.selectUser(userAcount,pwd);
        System.out.println("testSelectUser="+user);
    }




}
