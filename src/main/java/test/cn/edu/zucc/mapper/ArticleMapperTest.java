package test.cn.edu.zucc.mapper;

import cn.edu.zucc.mapper.ArticleManager;
import cn.edu.zucc.pojo.TbArticleEntity;
import cn.edu.zucc.pojo.TbCategoryEntity;
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
    private ArticleManager articleManager;



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
        articleManager.updateArticleInfo(tbArticleEntity);

    }

    @Test
    public void testCount() throws Exception {
        long connt = articleManager.getCount();
        System.out.println(connt);
    }


    @Test
    public void testFindArticleList() throws Exception {
        List<TbArticleEntity> articleEntities = (List<TbArticleEntity>) articleManager.findArticleList();
        for (int i = 0;i<articleEntities.size();i++) {
            System.out.print(articleEntities.get(i).getArticleTitle());
            System.out.print(articleEntities.get(i).getTbCategoryEntity().getCategoryId());
            System.out.println(articleEntities.get(i).getTbCategoryEntity().getCategoryName());
        }
    }

    @Test
    public void testFindByIdinfo() throws Exception {
       TbArticleEntity tbArticleEntity = articleManager.findByIdinfo(45);
        System.out.println(tbArticleEntity.toString());
    }

    @Test
    public void testFindByqQuery() throws Exception {
        List<TbArticleEntity> articleEntities = articleManager.findByqQuery("1",1);
        for (int i = 0;i<articleEntities.size();i++) {
            System.out.print(articleEntities.get(i).getArticleId());
            System.out.println(articleEntities.get(i).getArticleTitle());

        }
    }



}
