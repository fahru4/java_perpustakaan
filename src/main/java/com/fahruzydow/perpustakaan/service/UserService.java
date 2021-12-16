package com.fahruzydow.perpustakaan.service;

import com.fahruzydow.perpustakaan.dao.BaseDao;
import com.fahruzydow.perpustakaan.dao.UserDao;
import com.fahruzydow.perpustakaan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
   @Autowired
   private UserDao dao;

    @Override
    protected BaseDao<User> getDao() {
        return dao;
    }
}
