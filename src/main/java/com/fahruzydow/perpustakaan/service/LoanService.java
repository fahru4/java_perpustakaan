package com.fahruzydow.perpustakaan.service;

import com.fahruzydow.perpustakaan.dao.BaseDao;
import com.fahruzydow.perpustakaan.dao.LoanDao;
import com.fahruzydow.perpustakaan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService extends BaseService<Loan> {
    @Autowired
    private LoanDao dao;

    @Override
    protected BaseDao<Loan> getDao() {
        return dao;
    }
}
