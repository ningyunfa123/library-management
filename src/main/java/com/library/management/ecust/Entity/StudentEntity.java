package ecust.Entity;

/**
 * Created by Jonathon.Wang on 2017/3/12.
 */
public class StudentEntity {
    private int stuid;
    private String stuName;
    private String stuGender;
    private long stuCard;
    private int stuAge;

    public StudentEntity(int stuid, String stuName, String stuGender, long stuCard, int stuAge) {
        this.stuid = stuid;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuCard = stuCard;
        this.stuAge = stuAge;
    }

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
