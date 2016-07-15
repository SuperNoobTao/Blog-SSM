package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.ArticleMapper;
import cn.edu.zucc.mapper.CategoryMapper;
import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.service.ArticleService;
import cn.edu.zucc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shentao on 2016/7/14.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean addArticle(TbArticleEntity article, String contextPath, String realPath) {

        return false;
    }

    @Override
    public Map<String, Object> getArticleListParams(String contextPath) throws Exception {
        //最新三篇文章
        List<TbArticleEntity> lastArticles = null;
        lastArticles = articleMapper.findAllLastarticle();

        //列表顶置四篇文章
        List<TbArticleEntity> topArticles = null;
        topArticles  =  articleMapper.findAllToparticle();

        //所有类别
        List<TbCategoryEntity> categories = null;
        categories = categoryMapper.findAll();

        //封装模版所需参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("lastArticlesList", lastArticles);
        params.put("categories", categories);
        params.put("topArticles", topArticles);
        return params;
    }

    @Override
    public List<TbArticleEntity> getAllArtcles() throws Exception {
        return articleMapper.findAll();
    }

    @Override
    public List<TbArticleEntity> getArtclesList() throws Exception {
        return articleMapper.findAllToparticle();
    }

    @Override
    public List<TbArticleEntity> findByqQuery(String hql, int i) throws Exception {
        return articleMapper.findByqQuery(hql,i);
    }

    @Override
    public TbArticleEntity findById(Integer id) throws Exception {
        return articleMapper.findById(id);
    }

    @Override
    public Map<String, Object> getTemplateParams(int artid, String contextPath, boolean isNew) throws Exception {
        return null;
    }
}
