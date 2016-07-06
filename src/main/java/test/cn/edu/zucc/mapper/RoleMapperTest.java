package test.cn.edu.zucc.mapper;

import cn.edu.zucc.mapper.RoleMapper;
import cn.edu.zucc.mapper.UserMapper;
import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.pojo.TbUserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shentao on 2016/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mapper.xml"})
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testQueryById() throws Exception {
        int userId = 32;
        TbRoleEntity user = (TbRoleEntity) roleMapper.QueryByUserId(userId);
        System.out.println(user);
    }


}
