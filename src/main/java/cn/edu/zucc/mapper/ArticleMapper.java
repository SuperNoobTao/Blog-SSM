package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.pojo.TbCategoryEntity;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by shentao on 2016/7/13.
 */
public interface ArticleMapper {


    /**
     * 更新文章表面信息
     * @param tbArticleEntity
     * @throws Exception
     */
    public void updateArticleInfo(TbArticleEntity tbArticleEntity) throws Exception;


    /**
     * 查找文章条目数量
     * @return
     * @throws Exception
     */
    public  long getCount() throws Exception;


    /**
     * 查找所有文章
     * @return
     * @throws Exception
     */
    public List<TbArticleEntity> findAll() throws Exception;


    /**
     * 查找所有文章包括类别名
     * @return
     * @throws Exception
     */
    public List<TbArticleEntity> findArticleList() throws Exception;

    /**
     * 根据id查找文章
     * @param id
     * @throws Exception
     */
    public TbArticleEntity findById(Integer id) throws Exception;


    /**
     * 根据id查找文章信息（如喜爱数，阅读数）
     * @param id
     * @throws Exception
     */
    public TbArticleEntity findByIdinfo(Integer id) throws Exception;
    /**
     * xxxx
     * @param hql
     * @param i
     * @throws Exception
     */
    public List<TbArticleEntity> findByqQuery(String hql,int i);
    /**
     * 查找最新的三条记录
     * @return
     * @throws Exception
     */
    public List<TbArticleEntity> findAllLastarticle();

    /**
     * 查找顶端的四条记录
     * @return
     * @throws Exception
     */
    public List<TbArticleEntity> findAllToparticle();

    /**
     * 保存文章
     * @param  articleEntity
     * @return
     * @throws Exception
     */
    int save(TbArticleEntity articleEntity);


    /**
     * 删除文章
     * @param  id
     * @return
     * @throws Exception
     */
    int delete(int id);



    //    /**
//     * 更新文章
//     * @param  articleEntity
//     * @return
//     * @throws Exception
//     */
//    int update(TbArticleEntity articleEntity);
//查next
    public List<TbArticleEntity> findNextArticle(Timestamp Cdate);


    //查last
    public List<TbArticleEntity> findLastArticle(Timestamp Cdate);



}
