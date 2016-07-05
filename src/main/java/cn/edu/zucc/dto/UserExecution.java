package cn.edu.zucc.dto;

import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.enums.UserStateEnum;

/**
 * Created by shentao on 2016/7/4.
 */
public class UserExecution {

    // 用户账号
    private String userAcount;

    // 用户密码
    private String userPwd;
    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 登录成功对象
    private TbUserEntity tbUserEntity;

    public UserExecution() {
    }

    // 登录失败的构造器
    public UserExecution(String userAcount,String userPwd, UserStateEnum stateEnum) {
        this.userAcount = userAcount;
        this.userPwd = userPwd;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 登录成功的构造器
    public UserExecution(String userAcount,String userPwd, UserStateEnum stateEnum, TbUserEntity tbUserEntity) {
        this.userAcount = userAcount;
        this.userPwd = userPwd;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.tbUserEntity = tbUserEntity;
    }


    // getter和setter方法，toString方法


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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public TbUserEntity getTbUserEntity() {
        return tbUserEntity;
    }

    public void setTbUserEntity(TbUserEntity tbUserEntity) {
        this.tbUserEntity = tbUserEntity;
    }

    @Override
    public String toString() {
        return "UserExecution{" +
                "userAcount='" + userAcount + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", tbUserEntity=" + tbUserEntity +
                '}';
    }
}
