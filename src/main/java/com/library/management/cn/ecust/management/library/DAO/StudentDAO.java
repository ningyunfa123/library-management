package cn.ecust.management.library.DAO;

/**
 * Created by Jonathon.Wang on 2017/3/12.
 */
public class studentDAO {
    private int stuid;
    private String stuName;
    private String stuGender;
    private long stuCard;
    private int stuAge;

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public void setStuCard(long stuCard) {
        this.stuCard = stuCard;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public int getStuid() {
        return stuid;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public long getStuCard() {
        return stuCard;
    }

    public int getStuAge() {
        return stuAge;
    }
}
