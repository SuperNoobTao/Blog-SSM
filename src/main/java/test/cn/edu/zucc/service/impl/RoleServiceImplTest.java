package test.cn.edu.zucc.service.impl; 

import cn.edu.zucc.mapper.RoleMapper;
import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.service.RoleService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* RoleServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mapper.xml", "classpath*:spring-service.xml" })
public class RoleServiceImplTest { 

    @Autowired
    private RoleService roleService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getByUserId(int userId) 
* 
*/ 
@Test
public void testGetByUserId() throws Exception { 
//TODO: Test goes here...

    int userId =32;
    TbRoleEntity tbRoleEntity = roleService.getByUserId(userId);
    System.out.println(tbRoleEntity);
} 


} 
