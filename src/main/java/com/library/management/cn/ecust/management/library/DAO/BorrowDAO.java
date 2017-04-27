package com.library.management.cn.ecust.management.library.DAO;

import java.util.Date;

/**
 * Created by Jonathon.Wang on 2017/3/12.
 */
public class BorrowDAO {
    private int boid;
    private int stuid;
    private String stuName;
    private int bid;
    private short bookStatus;
    private String bookName;
    private String createDate;
    private  String updateData;

    public String getUpdateData() {
        return updateData;
    }

    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public short getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(short bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getBoid() {
        return boid;
    }

    public void setBoid(int boid) {
        this.boid = boid;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}
