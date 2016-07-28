package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.ArticleMapper;
import cn.edu.zucc.mapper.CategoryMapper;
import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.service.ArticleService;
import cn.edu.zucc.service.CategoryService;
import cn.edu.zucc.util.ServiceUtils;
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
        try {
            //保存数据库
            articleMapper.save(article);
            boolean result = true;
            article.setArticleId(article.getArticleId());

            //静态化页面
            List<TbCategoryEntity> list =categoryMapper.findAll();

            //静态化路径
            article.setArticleStaticUrl(article.staticPath());
            TbCategoryEntity category = categoryMapper.findById(article.getCategoryId());
            ServiceUtils.staticPage(article, contextPath, category, realPath);

            //储存静态化页面路径以及存储likes、looks等属性
            articleMapper.updateArticleInfo(article);

            return result;
        } catch (Exception e) {
            e.printStackTrace(); throw new RuntimeException(e);
        }

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
        return articleMapper.findArticleList();
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
        System.out.println("service中artid="+artid);
        //要看的文章
        TbArticleEntity articles = articleMapper.findById(artid);

        if (articles==null)
            return null;
        //最新三篇文章
        List<TbArticleEntity> lastArticles = null;
        lastArticles = articleMapper.findAllLastarticle();

        //所有类别
        List<TbCategoryEntity> categories = null;
        categories = categoryMapper.findAll();

        //下一篇
        TbArticleEntity next = null;
        List<TbArticleEntity> nextArticles = articleMapper.findNextArticle(articles.getArticleCdate());
        if (nextArticles == null || nextArticles.size() <= 0) {
            next = new TbArticleEntity();
            next.setArticleStaticUrl("#");
            next.setArticleTitle("这是最后一篇了哦！");
        } else {
            next = nextArticles.get(0);
            next.setArticleStaticUrl(contextPath + next.getArticleStaticUrl() + ".html");
        }

        //上一篇文章
        TbArticleEntity last = null;
        List<TbArticleEntity> lastAs = articleMapper.findLastArticle(articles.getArticleCdate());
        if (lastAs == null || lastAs.size() <= 0) {
            last = new TbArticleEntity();
            last.setArticleStaticUrl("#");
            last.setArticleTitle("这是第一篇哦！");
        } else {
            last = lastAs.get(0);
            last.setArticleStaticUrl(contextPath + last.getArticleStaticUrl() + ".html");
        }

        //封装模版所需参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("looked", articles.getArticleLooks());
        params.put("artid", artid);
        params.put("likes", articles.getArticleLikes());
        params.put("lastArticlesList", lastArticles);
        params.put("categoryList", categories);
        params.put("likesURL", contextPath + "/likeAction.action?artid=" + artid);
        params.put("nextArticle", next);
        params.put("lastArticle", last);
        params.put("staticURL", articles.getArticleStaticUrl());

        return params;
    }
}
