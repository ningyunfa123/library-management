package com.library.management.ecust.Excutor;

import com.library.management.cn.ecust.management.library.DAO.BorrowDAO;
import com.library.management.ecust.models.BorrowBookDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fage on 2017/4/24.
 */
public class BorrowBookBiz {
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
    public void borrowBook(List<BorrowBookDTO> borrowBookDTOS) throws Exception {
        if(borrowBookDTOS==null||borrowBookDTOS.size()==0){
            throw new Exception("请选择需要借的书");
        }
        for(BorrowBookDTO borrowBookDTO:borrowBookDTOS){
            if(borrowBookDTO.getBoId()==0||borrowBookDTO.getBookId()==0||borrowBookDTO.getBookName()==null||borrowBookDTO.getStudentId()==0||borrowBookDTO.getStudentName()==null){
                throw new Exception("书本信息不全请重新借书");
            }
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                BorrowDAO bd = returnBorrowDAO(borrowBookDTO);
                bd.setBookStatus((short) 0);
                bd.setCreateDate(sdf.format(new Date()));
                bd.setUpdateData(sdf.format(new Date()));
                asynDeleteData(borrowBookDTO);
                session.save(bd);
            }catch (Exception e){
                throw new Exception("借书失败");
            }finally{
                transaction.commit();
                session.close();
                sessionFactory.close();
            }
        }
    }
    @org.jetbrains.annotations.Contract("null -> fail")
    private BorrowDAO returnBorrowDAO(BorrowBookDTO borrowBookDTO) throws Exception {
        if(borrowBookDTO==null||borrowBookDTO.getBoId()==0||borrowBookDTO.getBookId()==0||borrowBookDTO.getStudentId()==0){
            throw new Exception("书本信息不全请重新借书");
        }
        BorrowDAO bd = new BorrowDAO();
        try {

            bd.setBid(borrowBookDTO.getBookId());
            bd.setBoid(borrowBookDTO.getBoId());
            bd.setBookName(borrowBookDTO.getBookName());
            bd.setStuid(borrowBookDTO.getStudentId());
            bd.setStuName(borrowBookDTO.getStudentName());
        }catch(Exception e){
            throw new Exception("借书异常");
        }
        return  bd;
    }
    @Async
    private void asynDeleteData(BorrowBookDTO borrowBookDTO) throws Exception {
        if(borrowBookDTO.getBookId()!=0){
            try {
                Query query = session.createQuery("delete from BookDAO bkd where bkd.bid=?");
                query.setParameter(0, borrowBookDTO.getBookId());
            }catch(Exception e){
                throw new Exception("获取书本失败");
            }
        }


    }
}
