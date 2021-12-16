package com.fahruzydow.perpustakaan.service;

import com.fahruzydow.perpustakaan.dao.BaseDao;
import com.fahruzydow.perpustakaan.dao.BookDao;
import com.fahruzydow.perpustakaan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book>{

    @Autowired
    private BookDao dao;

    @Override
    protected BaseDao<Book> getDao() {
        return null;
    }
}
