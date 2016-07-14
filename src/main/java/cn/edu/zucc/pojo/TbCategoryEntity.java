package cn.edu.zucc.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by shentao on 2016/5/31.
 */

public class TbCategoryEntity implements Serializable {
    private int categoryId;
    private String categoryName;
    private Timestamp categoryCdate;
    private Timestamp categoryMdate;
    private Timestamp categoryRdate;
    private String categoryRemark;


    @Override
    public String toString() {
        return "TbCategoryEntity{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCdate=" + categoryCdate +
                ", categoryMdate=" + categoryMdate +
                ", categoryRdate=" + categoryRdate +
                ", categoryRemark='" + categoryRemark + '\'' +
                '}';
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Timestamp getCategoryCdate() {
        return categoryCdate;
    }

    public void setCategoryCdate(Timestamp categoryCdate) {
        this.categoryCdate = categoryCdate;
    }

    public Timestamp getCategoryMdate() {
        return categoryMdate;
    }

    public void setCategoryMdate(Timestamp categoryMdate) {
        this.categoryMdate = categoryMdate;
    }

    public Timestamp getCategoryRdate() {
        return categoryRdate;
    }

    public void setCategoryRdate(Timestamp categoryRdate) {
        this.categoryRdate = categoryRdate;
    }

    public String getCategoryRemark() {
        return categoryRemark;
    }

    public void setCategoryRemark(String categoryRemark) {
        this.categoryRemark = categoryRemark;
    }
}
