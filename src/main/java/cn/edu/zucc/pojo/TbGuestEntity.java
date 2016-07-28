package cn.edu.zucc.pojo;

import java.io.Serializable;

/**
 * Created by shentao on 2016/7/17.
 */
public class TbGuestEntity  implements Serializable {
    private int guestId;
    private String guestName;
    private String guestEmail;
    private int guestRss;

    @Override
    public String toString() {
        return "TbGuestEntity{" +
                "guestId=" + guestId +
                ", guestName='" + guestName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", guestRss=" + guestRss +
                '}';
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public int getGuestRss() {
        return guestRss;
    }

    public void setGuestRss(int guestRss) {
        this.guestRss = guestRss;
    }


}
