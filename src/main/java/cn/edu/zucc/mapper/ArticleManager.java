package cn.edu.zucc.mapper;

import cn.edu.zucc.pojo.TbArticleEntity;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by shentao on 2016/7/13.
 */
public interface ArticleManager {

    /**
     * @param tbArticleEntity
     * @throws Exception
     */
    public void updateArticleInfo(TbArticleEntity tbArticleEntity) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    //查总数
    public  long getCount() throws Exception;

    //查所有
    public List<TbArticleEntity> findArticleList() throws Exception;

//    //查分页
//    List<TbArticleEntity> getPageData(String selection, Object[] params, int startindex, int pagesize) throws SQLException;

    //查单个byname
    public TbArticleEntity findByIdinfo(Integer id) throws Exception;

    //根据条件查询前几条
    public List<TbArticleEntity> findByqQuery(String hql,int i);

    //查最新的三条记录
    public List<TbArticleEntity> findAllLastarticle();

    //查顶端的四条记录
    public List<TbArticleEntity> findAllToparticle();

    //根据条件查询
    List<TbArticleEntity> queryArticleBySQL(String sql, Object[] params) throws SQLException;


//    //查分页
//    public List<ArticlesEntity> findArticles(int articleId);
//    //查next
//    public List<ArticlesEntity> findNextArticle(Timestamp Cdate);
//    //查last
//    public List<ArticlesEntity> findLastArticle(Timestamp Cdate);

}
