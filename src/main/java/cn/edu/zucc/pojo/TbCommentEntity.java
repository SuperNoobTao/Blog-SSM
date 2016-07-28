package cn.edu.zucc.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by shentao on 2016/7/17.
 */
public class TbCommentEntity  implements Serializable {
    private int commetId;
    private String commetContent;
    private int guestId;
    private int articleId;
    private Timestamp commetCdate;

    @Override
    public String toString() {
        return "TbCommentEntity{" +
                "commetId=" + commetId +
                ", commetContent='" + commetContent + '\'' +
                ", guestId=" + guestId +
                ", articleId=" + articleId +
                ", commetCdate=" + commetCdate +
                ", commetMdate=" + commetMdate +
                ", commetRdate=" + commetRdate +
                ", tbGuestEntity=" + tbGuestEntity +
                ", tbArticleEntity=" + tbArticleEntity +
                ", commetRemark='" + commetRemark + '\'' +
                '}';
    }

    private Timestamp commetMdate;
    private Timestamp commetRdate;

    public TbGuestEntity getTbGuestEntity() {
        return tbGuestEntity;
    }

    public void setTbGuestEntity(TbGuestEntity tbGuestEntity) {
        this.tbGuestEntity = tbGuestEntity;
    }

    private TbGuestEntity tbGuestEntity;
    private TbArticleEntity tbArticleEntity;

    public TbArticleEntity getTbArticleEntity() {
        return tbArticleEntity;
    }

    public void setTbArticleEntity(TbArticleEntity tbArticleEntity) {
        this.tbArticleEntity = tbArticleEntity;
    }






    public String getCommetRemark() {
        return commetRemark;
    }

    public void setCommetRemark(String commetRemark) {
        this.commetRemark = commetRemark;
    }

    public Timestamp getCommetRdate() {
        return commetRdate;
    }

    public void setCommetRdate(Timestamp commetRdate) {
        this.commetRdate = commetRdate;
    }

    public Timestamp getCommetMdate() {
        return commetMdate;
    }

    public void setCommetMdate(Timestamp commetMdate) {
        this.commetMdate = commetMdate;
    }

    public Timestamp getCommetCdate() {
        return commetCdate;
    }

    public void setCommetCdate(Timestamp commetCdate) {
        this.commetCdate = commetCdate;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getCommetContent() {
        return commetContent;
    }

    public void setCommetContent(String commetContent) {
        this.commetContent = commetContent;
    }

    public int getCommetId() {
        return commetId;
    }

    public void setCommetId(int commetId) {
        this.commetId = commetId;
    }

    private String commetRemark;

}
