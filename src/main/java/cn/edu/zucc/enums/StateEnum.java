package cn.edu.zucc.enums;

/**
 * Created by shentao on 2016/7/4.
 */
public enum StateEnum {

    SUCCESS(1, "alert-success"), INFO(0, "alert-info"), WARING(-1, "alert-warning"), ERROR(-2, "alert-danger");

    private int state;

    private String stateInfo;

    private StateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static StateEnum stateOf(int index) {
        for (StateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;}
}
