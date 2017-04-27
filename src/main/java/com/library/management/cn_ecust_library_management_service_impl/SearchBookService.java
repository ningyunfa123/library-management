package com.library.management.cn_ecust_library_management_service_impl;

import com.library.management.cn_ecust_library_management_service_API.ISearchBookService;
import com.library.management.ecust.Entity.BookEntity;
import com.library.management.ecust.Excutor.SearchBookBiz;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Created by fage on 2017/4/27.
 */
public class SearchBookService implements ISearchBookService {

    @Autowired
    private SearchBookBiz searchBookBiz;
    private static final Log logger = LogFactory.getLog(SearchBookService.class);
    public BookEntity searchBookBybid(int bid) {
        logger.info(String.format("param:%s",bid));
        return searchBookBiz.searchBookBybid(bid);
    }

    public List<BookEntity> searchBookByBookName(String bookName) throws Exception {
        logger.info(String.format("param:%s",bookName));

        return searchBookBiz.searchBookByBookName(bookName);
    }

    public List<BookEntity> searchBookByAuthorName(String authorName) throws Exception {
        logger.info(String.format("param:%s",authorName));
        return searchBookBiz.searchBookByAuthorName(authorName);
    }
}
