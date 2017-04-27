package com.library.management.ecust.Excutor;

import com.library.management.cn.ecust.management.library.DAO.BookDAO;
import com.library.management.ecust.Entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by fage on 2017/4/22.
 */
public class SearchBookBiz {

    private SessionFactory sessionFactory;

    private Session session ;

    private Transaction transaction ;


    @PostConstruct
    public void init(){
        Configuration cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.getTransaction();
    }
    public static void main(String[] args){

    }
    public BookEntity searchBookBybid(Integer bid){
        if(bid==null||bid==0){
            System.out.print("请输入正确的id");
            return null;
        }
        BookEntity bookEntity = new BookEntity();
        try {
            BookDAO bookDAO = (BookDAO) session.get(BookDAO.class, bid);
            bookEntity.setBid(bid);
            bookEntity.setBookAuthor(bookDAO.getBookAuthor());
            bookEntity.setBookName(bookDAO.getBookName());
            bookEntity.setBookPublished(bookDAO.getBookPublished());
            bookEntity.setPublishYear(bookDAO.getPublishYear());
        } catch (Exception e) {
            System.out.print("没有找到文件");
        } finally {
            transaction.commit();
            session.close();
            sessionFactory.close();
        }
        return bookEntity;
    }
    public List<BookEntity>  searchBookByBookName(String bookName) throws Exception {
        if(bookName==null||bookName.length()==0) {
            throw new Exception("请输入正确的书名");
        }
        List<BookEntity> bookEntityList = new ArrayList<BookEntity>();
        try {

            Query query = session.createQuery("from BookDAO as boo where boo.bookName like ?");
            query.setParameter(0, bookName);
            List<BookDAO> bookDAOList = (List<BookDAO>) query.list();
            for(BookDAO bd:bookDAOList){
                bookEntityList.add(returnBookEn(bd));
            }
        }catch (Exception e){
            throw new Exception("no files");

        }finally {
            transaction.commit();
            session.close();
            sessionFactory.close();
        }
        return bookEntityList;
    }
    public List<BookEntity> searchBookByAuthorName(String authorName) throws Exception {
        if(authorName==null||authorName.length()==0){
            System.out.print("请输入正确的作者名");
            return null;
        }
        List<BookEntity> bookEntityList = new ArrayList<BookEntity>();
        try{
            Query query = session.createQuery("from BookDAO bok where bok.authorName=?");
            query.setParameter(0,authorName);
            List<BookDAO> bdList = (List<BookDAO>) query.list();
            for(BookDAO bkd:bdList){
                bookEntityList.add(returnBookEn(bkd));
            }
        }catch (Exception e){
            throw new Exception("no such files");
        }finally{
            transaction.commit();
            session.close();
            sessionFactory.close();
        }
        return bookEntityList;
    }
    private BookEntity returnBookEn(BookDAO bookDAO){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookDAO.getBookName());
        bookEntity.setBid(bookDAO.getBid());
        bookEntity.setBookAuthor(bookDAO.getBookAuthor());
        bookEntity.setBookPublished(bookDAO.getBookPublished());
        bookEntity.setPublishYear(bookDAO.getPublishYear());
        return bookEntity;
    }
}

