package test.cn.edu.zucc.service.impl;

import cn.edu.zucc.entity.TbUserEntity;
import cn.edu.zucc.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 5, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring-dao.xml", "classpath*:spring-service.xml" })
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getById(long userId) 
* 
*/ 
@Test
public void testGetById() throws Exception { 
//TODO: Test goes here...
long userId =32;
TbUserEntity tbUserEntity = userService.getById(userId);
System.out.println(tbUserEntity);
}

    @Test
    public void testGetByName() throws Exception {
//TODO: Test goes here...
        String userAcount ="1";
        TbUserEntity tbUserEntity = userService.getByName(userAcount);
        System.out.println(tbUserEntity);
    }


} 
