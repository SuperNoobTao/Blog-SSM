package test.cn.edu.zucc.mapper;

import cn.edu.zucc.mapper.ArticleMapper;
import cn.edu.zucc.pojo.TbArticleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by shentao on 2016/7/13.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mapper.xml"})
public class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;



    @Test
    public void testUpdateArticleInfo() throws Exception {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        int articleLikes =11;
        int articleLooks =11;
        String url = "1111";
        TbArticleEntity tbArticleEntity = new TbArticleEntity();
        tbArticleEntity.setArticleLikes(articleLikes);
        tbArticleEntity.setArticleCdate(now);
        tbArticleEntity.setArticleLooks(articleLooks);
        tbArticleEntity.setArticleStaticUrl(url);
        tbArticleEntity.setArticleId(45);
        articleMapper.updateArticleInfo(tbArticleEntity);

    }

    @Test
    public void testCount() throws Exception {
        long connt = articleMapper.getCount();
        System.out.println(connt);
    }


    @Test
    public void testFindArticleList() throws Exception {
        List<TbArticleEntity> articleEntities = (List<TbArticleEntity>) articleMapper.findArticleList();
        for (int i = 0;i<articleEntities.size();i++) {
            System.out.print(articleEntities.get(i).getArticleTitle());
            System.out.print(articleEntities.get(i).getTbCategoryEntity().getCategoryId());
            System.out.println(articleEntities.get(i).getTbCategoryEntity().getCategoryName());
        }
    }

    @Test
    public void testFindByIdinfo() throws Exception {
       TbArticleEntity tbArticleEntity = articleMapper.findByIdinfo(45);
        System.out.println(tbArticleEntity.toString());
    }

    @Test
    public void testFindByqQuery() throws Exception {
        List<TbArticleEntity> articleEntities = articleMapper.findByqQuery("1",1);
        for (int i = 0;i<articleEntities.size();i++) {
            System.out.print(articleEntities.get(i).getArticleId());
            System.out.println(articleEntities.get(i).getArticleTitle());

        }
    }

    @Test
    public void testFindAllLastarticle() throws Exception {
        List<TbArticleEntity> articleEntities = articleMapper.findAllLastarticle();
        for (int i = 0;i<articleEntities.size();i++) {
            System.out.print(articleEntities.get(i).getArticleId());
            System.out.println(" "+articleEntities.get(i).getArticleTitle());

        }
    }


    @Test
    public void testFindAllToparticle() throws Exception {
        List<TbArticleEntity> articleEntities = articleMapper.findAllToparticle();
        for (int i = 0;i<articleEntities.size();i++) {
            System.out.print(articleEntities.get(i).getArticleId());
            System.out.println(" "+articleEntities.get(i).getArticleTitle());

        }
    }

    @Test
    public void testSave() throws Exception {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        TbArticleEntity articleEntity = new TbArticleEntity();
        articleEntity.setArticleCdate(now);
        articleEntity.setArticleLooks(0);
        articleEntity.setCategoryId(15);
        articleEntity.setArticleStaticUrl("11");
        articleEntity.setArticleAuthor("st");
        articleEntity.setArticleContent("asdsad");
        articleEntity.setArticleLikes(0);
        articleEntity.setArticleMeta("meta");
        articleEntity.setArticleRemark("remark");
        articleEntity.setArticleTitle("title");
        articleEntity.setArticleTop(0);
        articleEntity.setArticleType("type");
        articleEntity.setUserId(32);
        articleEntity.setArticleType("type");

        int i = articleMapper.save(articleEntity);
        System.out.println(i);





    }




}
