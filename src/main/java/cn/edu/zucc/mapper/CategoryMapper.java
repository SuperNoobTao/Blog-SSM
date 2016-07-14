package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbCategoryEntity;

import java.util.List;

/**
 * Created by shentao on 2016/7/13.
 */
public interface CategoryMapper {


    /**
     * @param categoryName
     * @return
     * @throws Exception
     */
    public TbCategoryEntity findByName(String categoryName) throws Exception;


    //查所有
    public List<TbCategoryEntity> findAll() throws Exception;


    //查总数
    public  long getCount() throws Exception;

}
