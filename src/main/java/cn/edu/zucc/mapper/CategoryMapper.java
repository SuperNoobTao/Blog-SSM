package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbCategoryEntity;

import java.util.List;

/**
 * Created by shentao on 2016/7/13.
 */
public interface CategoryMapper {


    /**
     * 按名字查找类别
     * @param categoryName
     * @return
     * @throws Exception
     */
    public TbCategoryEntity findByName(String categoryName) throws Exception;

    /**
     * 按ID查找类别
     * @param id
     * @return
     * @throws Exception
     */
    public TbCategoryEntity findById(int id) throws Exception;

    /**
     * 查找所有的类别
     * @param
     * @return
     * @throws Exception
     */
    public List<TbCategoryEntity> findAll() throws Exception;


    /**
     * 查找条目数量
     * @param
     * @return
     * @throws Exception
     */
    public  long getCount() throws Exception;

    /**
     * 保存类别
     * @param  categoryEntity
     * @return
     * @throws Exception
     */
    int save(TbCategoryEntity categoryEntity);


    /**
     * 删除类别
     * @param  id
     * @return
     * @throws Exception
     */
    int delete(int id);



    /**
     * 更新类别
     * @param  categoryEntity
     * @return
     * @throws Exception
     */
    int update(TbCategoryEntity categoryEntity);

}
