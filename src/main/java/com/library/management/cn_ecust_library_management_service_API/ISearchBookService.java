package com.library.management.cn_ecust_library_management_service_API;

import com.library.management.ecust.Entity.BookEntity;

import java.util.List;

/**
 * Created by fage on 2017/4/26.
 */
public interface ISearchBookService {

    /**
     * @param bid 主键
     */
    BookEntity searchBookBybid(int bid);

    /**
     * @param bookName 书名
     */
    List<BookEntity> searchBookByBookName(String bookName) throws Exception;

    /**
     * @param authorName 书名
     */
    List<BookEntity> searchBookByAuthorName(String authorName) throws Exception;
}
