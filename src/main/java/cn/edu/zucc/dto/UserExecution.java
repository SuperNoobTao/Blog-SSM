package cn.edu.zucc.dto;

import cn.edu.zucc.entity.TbUserEntity;
import cn.edu.zucc.enums.UserStateEnum;

/**
 * Created by shentao on 2016/7/4.
 */
public class UserExecution {

    // 用户ID
    private long userId;

    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 预约成功对象
    private TbUserEntity tbUserEntity;

    public UserExecution() {
    }

    // 预约失败的构造器
    public UserExecution(long userId, UserStateEnum stateEnum) {
        this.userId = userId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 预约成功的构造器
    public UserExecution(long userId, UserStateEnum stateEnum, TbUserEntity tbUserEntity) {
        this.userId = userId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.tbUserEntity = tbUserEntity;
    }


    // 省略getter和setter方法，toString方法
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
