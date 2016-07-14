package cn.edu.zucc.service;

import cn.edu.zucc.pojo.TbCategoryEntity;

import java.util.List;

/**
 * Created by shentao on 2016/7/14.
 */
public interface CategoryService {

    //得到所有类别
    public List<TbCategoryEntity> getAllCategories() throws Exception;

    //添加类别
    public  boolean  addCategory(TbCategoryEntity tbCategoryEntity)  throws Exception;

    //删除类别
    public boolean deleteCategory(int categoryId);

    //查询指定类别
    public TbCategoryEntity queryCategory(Integer id) throws Exception;

    public TbCategoryEntity findByName(String hql) throws Exception;

    //更新类别
    public boolean updateCategory(TbCategoryEntity tbCategoryEntity)  throws Exception;




}
