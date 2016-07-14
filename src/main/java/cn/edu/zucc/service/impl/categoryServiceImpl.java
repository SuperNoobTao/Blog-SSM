package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.CategoryMapper;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.service.CategoryService;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shentao on 2016/7/14.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<TbCategoryEntity> getAllCategories() throws Exception {
        return categoryMapper.findAll();
    }

    @Override
    @Transactional
    public boolean addCategory(TbCategoryEntity tbCategoryEntity) throws Exception {
        int i = categoryMapper.save(tbCategoryEntity);
        if (i>0) {
            return  true;
        }
            return  false;
    }

    @Override
    @Transactional
    public boolean deleteCategory(int categoryId) {
        int i = categoryMapper.delete(categoryId);
        if (i>0) {
            return true;
        }
        return false;
    }

    @Override
    public TbCategoryEntity queryCategory(Integer id) throws Exception {
        return categoryMapper.findById(id);
    }

    @Override
    public TbCategoryEntity findByName(String name) throws Exception {
        return categoryMapper.findByName(name);
    }

    @Override
    @Transactional
    public boolean updateCategory(TbCategoryEntity tbCategoryEntity) throws Exception {
        int i = categoryMapper.update(tbCategoryEntity);
        if (i> 0) {
            return  true;
        }
        return false;
    }
}
