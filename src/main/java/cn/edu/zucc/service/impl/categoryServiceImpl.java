package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.CategoryMapper;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.service.CategoryService;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shentao on 2016/7/14.
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<TbCategoryEntity> getAllCategories() throws Exception {
        return categoryMapper.findAll();
    }

    @Override
    public boolean addCategory(TbCategoryEntity tbCategoryEntity) throws Exception {
        return  false;
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        return false;
    }

    @Override
    public TbCategoryEntity queryCategory(Integer id) throws Exception {
        return null;
    }

    @Override
    public TbCategoryEntity findByName(String hql) throws Exception {
        return null;
    }

    @Override
    public boolean updateCategory(TbCategoryEntity tbCategoryEntity) throws Exception {
        return false;
    }
}
