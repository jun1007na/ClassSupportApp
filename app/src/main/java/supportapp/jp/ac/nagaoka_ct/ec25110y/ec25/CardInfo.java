package supportapp.jp.ac.nagaoka_ct.ec25110y.ec25;

/**
 * Created by junya on 2015/10/12.
 */
public class CardInfo {
    private String mSjTitle;
    private String mTime;
    private String mOther;

    public String getSjTitle() {
        return mSjTitle;
    }

    public void setSjTitle(String title) {
        this.mSjTitle = title;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }

    public String getOther() {
        return mOther;
    }

    public void setOther(String other) {
        this.mOther = other;
    }
}
