package test.cn.edu.zucc.mapper;

import cn.edu.zucc.mapper.CategoryMapper;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.pojo.TbRoleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by shentao on 2016/7/13.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mapper.xml"})
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testFindByName() throws Exception {
        String categoryName = "java";
        TbCategoryEntity categoryEntity = (TbCategoryEntity) categoryMapper.findByName(categoryName);
        System.out.println(categoryEntity);
    }

    @Test
    public void testFindAll() throws Exception {

        List<TbCategoryEntity> categoryEntity = (List<TbCategoryEntity>) categoryMapper.findAll();
        for (int i = 0;i<categoryEntity.size();i++) {
            System.out.println(categoryEntity.get(i).getCategoryName());
        }
    }

    @Test
    public void testCount() throws Exception {
        long count = categoryMapper.getCount();
        System.out.println(count);
    }


}
