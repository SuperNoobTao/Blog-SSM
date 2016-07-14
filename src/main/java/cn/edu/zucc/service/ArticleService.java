package cn.edu.zucc.service;

import cn.edu.zucc.pojo.TbArticleEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by shentao on 2016/7/14.
 */
public interface ArticleService {
    /**
     * 添加文章 半静态化
     * @param article
     * @param contextPath
     * @param realPath
     * @return
     */
    public boolean addArticle(TbArticleEntity article, String contextPath, String realPath);


    /**
     * 得到模板参数
     * @param contextPath
     * @return
     * @throws Exception
     */
    public Map<String, Object> getArticleListParams(String contextPath) throws Exception;


    /**
     * 查询所有文章
     * @return
     * @throws Exception
     */
    public List<TbArticleEntity> getAllArtcles() throws Exception;


    /**
     * 查找顶端的所有文章
     * @return
     * @throws Exception
     */
    public List<TbArticleEntity> getArtclesList() throws Exception;


    /**
     * 通过参数查询文章
     * @param hql
     * @param i
     * @return
     * @throws Exception
     */
    public List<TbArticleEntity> findByqQuery(String hql,int i) throws Exception;


    /**
     * 通过ID查询文章
     * @param id
     * @return
     * @throws Exception
     */
    public TbArticleEntity findById(Integer id) throws Exception;


    /**
     * 得到freemarker模版文件所需参数
     * @param artid
     * @param contextPath
     * @param isNew
     * @return
     * @throws Exception
     */
    public Map<String, Object> getTemplateParams(int artid, String contextPath, boolean isNew) throws Exception;



}
