package com.library.management.cn.ecust.management.library.DAO;


import org.hibernate.annotations.Table;

/**
 * Created by fage on 2017/4/22.
 */
@Table(appliesTo = "bookinfo")
public class BookDAO {
    private int bid;
    private String bookName;
    private String bookAuthor;
    private String bookPublished;
    private int publishYear;


    public int getBid() {
        return bid;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPublished() {
        return bookPublished;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublishment(String bookPublished) {
        this.bookPublished = bookPublished;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}
