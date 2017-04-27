package com.library.management.ecust.Entity;

/**
 * Created by Jonathon.Wang on 2017/3/12.
 */
public class BookEntity {
    private Integer bid;
    private String bookName;
    private String bookAuthor;
    private String bookPublished;
    private Integer publishYear;
    public BookEntity(){

    }
    public BookEntity(Integer bid, String bookName, String bookAuthor, String bookPublished, Integer publishYear) {
        this.bid = bid;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublished = bookPublished;
        this.publishYear = publishYear;
    }

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
        return this.bookPublished;
    }

    public int getPublishYear() {
        return this.publishYear;
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

    public void setBookPublished(String bookPublishment) {
        this.bookPublished = bookPublished;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}
