package cn.edu.zucc.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by shentao on 2016/5/31.
 */
public class TbUserEntity implements Serializable {

    public static final String USER_STATE_OK = "正常";
    public static final String USER_STATE_DISABLE = "禁用";
    public static final String SESSION_KEY = "curr_user";



    private int userId;
    private String userAcount;
    private String userPwd;
    private String userName;
    private String userSex;
    private String userPhone;
    private String userEmail;
    private Timestamp userCdate;
    private Timestamp userMdate;
    private Timestamp userRdate;
    private String userState;
    private String userType;
    private String userRemark;



    @Override
    public String toString() {
        return "TbUserEntity{" +
                "userId=" + userId +
                ", userAcount='" + userAcount + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userCdate=" + userCdate +
                ", userMdate=" + userMdate +
                ", userRdate=" + userRdate +
                ", userState='" + userState + '\'' +
                ", userType='" + userType + '\'' +
                ", userRemark='" + userRemark + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAcount() {
        return userAcount;
    }

    public void setUserAcount(String userAcount) {
        this.userAcount = userAcount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Timestamp getUserCdate() {
        return userCdate;
    }

    public void setUserCdate(Timestamp userCdate) {
        this.userCdate = userCdate;
    }

    public Timestamp getUserMdate() {
        return userMdate;
    }

    public void setUserMdate(Timestamp userMdate) {
        this.userMdate = userMdate;
    }

    public Timestamp getUserRdate() {
        return userRdate;
    }

    public void setUserRdate(Timestamp userRdate) {
        this.userRdate = userRdate;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }
}
