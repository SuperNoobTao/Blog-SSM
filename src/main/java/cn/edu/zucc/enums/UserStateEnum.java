package cn.edu.zucc.enums;

/**
 * Created by shentao on 2016/7/4.
 */
public enum UserStateEnum {

    SUCCESS_LOGIN(1, "登录成功"), SUCCESS_REG(0, "注册成功"), NO_USER(-1, "无此用户"), INNER_ERROR(-2, "系统异常");
    private int state;

    private String stateInfo;

    private UserStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static UserStateEnum stateOf(int index) {
        for (UserStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;}
}
