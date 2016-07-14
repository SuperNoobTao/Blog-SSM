package cn.edu.zucc.service.impl;

import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.service.ArticleService;

import java.util.List;
import java.util.Map;

/**
 * Created by shentao on 2016/7/14.
 */
public class ArticleServiceImpl implements ArticleService{

    @Override
    public boolean addArticle(TbArticleEntity article, String contextPath, String realPath) {
        return false;
    }

    @Override
    public Map<String, Object> getArticleListParams(String contextPath) throws Exception {
        return null;
    }

    @Override
    public List<TbArticleEntity> getAllArtcles() throws Exception {
        return null;
    }

    @Override
    public List<TbArticleEntity> getArtclesList() throws Exception {
        return null;
    }

    @Override
    public List<TbArticleEntity> findByqQuery(String hql, int i) throws Exception {
        return null;
    }

    @Override
    public TbArticleEntity findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getTemplateParams(int artid, String contextPath, boolean isNew) throws Exception {
        return null;
    }
}
