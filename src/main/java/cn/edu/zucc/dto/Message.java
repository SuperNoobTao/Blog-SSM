package cn.edu.zucc.dto;

import cn.edu.zucc.enums.StateEnum;


/**
 * Created by shentao on 2016/7/4.
 */
public class Message {

    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;


    public Message() {
    }

    // 操作构造器
    public Message(StateEnum stateEnum) {

        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // getter和setter方法，toString方法

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


    @Override
    public String toString() {
        return "Message{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
