package cn.edu.zucc.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by shentao on 2016/5/31.
 */

public class TbArticleEntity implements Serializable{
    private int articleId;
    private String articleAuthor;
    private int articleLikes;
    private int articleLooks;
    private String articleTitle;
    private String articleMeta;
    private String articleContent;
    private String articleStaticUrl;
    private String articleType;
    private int articleTop;
    private String articleRemark;
    private Timestamp articleCdate;
    private Timestamp articleMdate;
    private Timestamp articleRdate;
    private int userId;
    private int categoryId;
    private TbCategoryEntity tbCategoryEntity;



    public String staticPath(){
        return "/blog/" + getCategoryId() + "/" + getCategoryId() + "-" + articleId;
    }

    @Override
    public String toString() {
        return "TbArticleEntity{" +
                "articleId=" + articleId +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleLikes=" + articleLikes +
                ", articleLooks=" + articleLooks +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleMeta='" + articleMeta + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleStaticUrl='" + articleStaticUrl + '\'' +
                ", articleType='" + articleType + '\'' +
                ", articleTop=" + articleTop +
                ", articleRemark='" + articleRemark + '\'' +
                ", articleCdate=" + articleCdate +
                ", articleMdate=" + articleMdate +
                ", articleRdate=" + articleRdate +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                '}';
    }
    public TbCategoryEntity getTbCategoryEntity() {
        return tbCategoryEntity;
    }

    public void setTbCategoryEntity(TbCategoryEntity tbCategoryEntity) {
        this.tbCategoryEntity = tbCategoryEntity;
    }
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public int getArticleLikes() {
        return articleLikes;
    }

    public void setArticleLikes(int articleLikes) {
        this.articleLikes = articleLikes;
    }

    public int getArticleLooks() {
        return articleLooks;
    }

    public void setArticleLooks(int articleLooks) {
        this.articleLooks = articleLooks;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleMeta() {
        return articleMeta;
    }

    public void setArticleMeta(String articleMeta) {
        this.articleMeta = articleMeta;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleStaticUrl() {
        return articleStaticUrl;
    }

    public void setArticleStaticUrl(String articleStaticUrl) {
        this.articleStaticUrl = articleStaticUrl;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public int getArticleTop() {
        return articleTop;
    }

    public void setArticleTop(int articleTop) {
        this.articleTop = articleTop;
    }

    public String getArticleRemark() {
        return articleRemark;
    }

    public void setArticleRemark(String articleRemark) {
        this.articleRemark = articleRemark;
    }

    public Timestamp getArticleCdate() {
        return articleCdate;
    }

    public void setArticleCdate(Timestamp articleCdate) {
        this.articleCdate = articleCdate;
    }

    public Timestamp getArticleMdate() {
        return articleMdate;
    }

    public void setArticleMdate(Timestamp articleMdate) {
        this.articleMdate = articleMdate;
    }

    public Timestamp getArticleRdate() {
        return articleRdate;
    }

    public void setArticleRdate(Timestamp articleRdate) {
        this.articleRdate = articleRdate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
