package com.library.management.ecust.Excutor;

import com.library.management.cn.ecust.management.library.DAO.BookDAO;
import com.library.management.cn.ecust.management.library.DAO.BorrowDAO;
import com.library.management.ecust.Entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * Created by fage on 2017/4/25.
 */

public class ReturnBookBiz {

    private final SearchBookBiz searchBookBiz;

    private SessionFactory sessionFactory;

    private Session session ;

    private Transaction transaction ;

    @Autowired
    public ReturnBookBiz(SearchBookBiz searchBookBiz) {
        this.searchBookBiz = searchBookBiz;
    }

    @PostConstruct
    public void init(){
        Configuration cfg = new Configuration();
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
        cfg.configure();
        transaction = session.getTransaction();
    }

    public Integer returnBook(int stuid, int bid) throws Exception {
        if(bid!=0) {
            Query query = session.createQuery("from BorrowDAO brd where brd.bid=? order by brd.boDate desc ");
            query.setParameter(0, bid);
            List<BorrowDAO> brolist = (List<BorrowDAO>) query.list();
            BorrowDAO borrowDAO = brolist.get(0);
            if(borrowDAO.getStuid()!=stuid){
                throw new Exception("您无权还书");
            }
            if(borrowDAO.getBookStatus()!=0){
                throw new Exception("您已归还过该书请勿重复归还");
            }
            try {
                BookDAO bookDAO = new BookDAO();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                borrowDAO.setBookStatus((short) 1);
                borrowDAO.setUpdateData(sdf.format(new Date()));
                BookEntity bookEntity = searchBookBiz.searchBookBybid(bid);
                bookDAO.setBid(bookEntity.getBid());
                bookDAO.setBookAuthor(bookEntity.getBookAuthor());
                bookDAO.setBookName(bookEntity.getBookName());
                bookDAO.setBookPublishment(bookEntity.getBookPublished());
                bookDAO.setPublishYear(bookEntity.getPublishYear());
                session.save(bookDAO);
                session.save(borrowDAO);
            }catch (Exception e){
                throw new Exception("还书失败");
            }finally {
                transaction.commit();
                session.close();
                sessionFactory.close();
            }
        }
        return 1;
    }
}
