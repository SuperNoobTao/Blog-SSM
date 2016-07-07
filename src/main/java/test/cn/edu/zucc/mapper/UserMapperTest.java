package test.cn.edu.zucc.mapper;

/**
 * Created by shentao on 2016/7/5.
 */

import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.Timestamp;
import java.util.Date;

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



    @Test
    public void testSave() throws Exception {
        String userAcount = "1";
        String pwd = "1";
        String userName = "沈涛";
        String user_sex = "男";
        String user_phone = "1516719522";
        String user_email = "3@3.com";
        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
        TbUserEntity user =new TbUserEntity();
        user.setUserAcount(userAcount);
        user.setUserPwd(pwd);
        user.setUserName(userName);
        user.setUserSex(user_sex);
        user.setUserPhone(user_phone);
        user.setUserEmail(user_email);
        user.setUserCdate(now);
        int i = userMapper.save(user);
        System.out.println(user.getUserId());
    }
    @Test
    public void testSaveUserAndRole() throws Exception {

        userMapper.saveUserAndRole(52,1);


    }



    @Test
    public void testCountByAcount() throws Exception {

        int i = userMapper.countByAcount("21311112");
        int j =  userMapper.countByEmail("3@3.com");
        System.out.println(i);
        System.out.println(j);

    }
}
