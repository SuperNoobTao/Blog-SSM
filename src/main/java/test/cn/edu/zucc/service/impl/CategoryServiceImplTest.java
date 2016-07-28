package test.cn.edu.zucc.service.impl; 

import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.service.CategoryService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/** 
* CategoryServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ÆßÔÂ 14, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mapper.xml", "classpath*:spring-service.xml" })
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAllCategories() 
* 
*/ 
@Test
public void testGetAllCategories() throws Exception { 
//TODO: Test goes here...
    List<TbCategoryEntity> list = categoryService.getAllCategories();
    for (int i =0 ; i<list.size() ;i++) {
        System.out.println(list.get(i).toString());
    }
} 

/** 
* 
* Method: addCategory(TbCategoryEntity tbCategoryEntity) 
* 
*/ 
@Test
public void testAddCategory() throws Exception { 
//TODO: Test goes here...
    Timestamp now = new Timestamp(System.currentTimeMillis());
    TbCategoryEntity categoryEntity = new TbCategoryEntity();
    categoryEntity.setCategoryName("name");
    categoryEntity.setCategoryRemark("remark");
    categoryEntity.setCategoryCdate(now);
    System.out.println(categoryService.addCategory(categoryEntity));
} 

/** 
* 
* Method: deleteCategory(int categoryId) 
* 
*/ 
@Test
public void testDeleteCategory() throws Exception { 
//TODO: Test goes here...
    System.out.println(categoryService.deleteCategory(16));
} 

/** 
* 
* Method: queryCategory(Integer id) 
* 
*/ 
@Test
public void testQueryCategory() throws Exception { 
//TODO: Test goes here...
    TbCategoryEntity categoryEntity = categoryService.queryCategory(17);
    System.out.println(categoryEntity.toString());
} 

/** 
* 
* Method: findByName(String name) 
* 
*/ 
@Test
public void testFindByName() throws Exception { 
//TODO: Test goes here...
    TbCategoryEntity categoryEntity = categoryService.findByName("name");
    System.out.println(categoryEntity.toString());
} 

/** 
* 
* Method: updateCategory(TbCategoryEntity tbCategoryEntity) 
* 
*/ 
@Test
public void testUpdateCategory() throws Exception { 
//TODO: Test goes here...
    Timestamp now = new Timestamp(System.currentTimeMillis());
    TbCategoryEntity categoryEntity = new TbCategoryEntity();
    categoryEntity.setCategoryName("rname");
    categoryEntity.setCategoryRemark("rrmark");
    categoryEntity.setCategoryCdate(now);
    categoryEntity.setCategoryId(17);
    boolean i = categoryService.updateCategory(categoryEntity);
    System.out.println(categoryEntity.toString());


} 


} 
