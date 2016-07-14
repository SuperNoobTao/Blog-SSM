package cn.edu.zucc.service;

import cn.edu.zucc.pojo.TbCategoryEntity;

import java.util.List;

/**
 * Created by shentao on 2016/7/14.
 */
public interface CategoryService {

    /**
     * 得到所有类别
     * @return
     * @throws Exception
     */
    public List<TbCategoryEntity> getAllCategories() throws Exception;


    /**
     * 添加类别
     * @param tbCategoryEntity
     * @return
     * @throws Exception
     */
    public  boolean  addCategory(TbCategoryEntity tbCategoryEntity)  throws Exception;


    /**
     * 删除类别
     * @param categoryId
     * @return
     */
    public boolean deleteCategory(int categoryId);


    /**
     * 查询指定类别
     * @param id
     * @return
     * @throws Exception
     */
    public TbCategoryEntity queryCategory(Integer id) throws Exception;


    /**
     * 查询指定类别ByName
     * @param name
     * @return
     * @throws Exception
     */
    public TbCategoryEntity findByName(String name) throws Exception;


    /**
     * 更新类别
     * @param tbCategoryEntity
     * @return
     * @throws Exception
     */
    public boolean updateCategory(TbCategoryEntity tbCategoryEntity)  throws Exception;




}
