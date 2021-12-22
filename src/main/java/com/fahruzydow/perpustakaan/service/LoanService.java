package com.fahruzydow.perpustakaan.service;

import com.fahruzydow.perpustakaan.PerpustakaanApplication;
import com.fahruzydow.perpustakaan.dao.BaseDao;
import com.fahruzydow.perpustakaan.dao.LoanDao;
import com.fahruzydow.perpustakaan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class LoanService extends BaseService<Loan> {
    @Autowired
    private LoanDao dao;

    @Override
    protected BaseDao<Loan> getDao() {
        return dao;
    }

    @Transactional
    public Loan save(Loan entity){
        entity.setLoanDate(new Date());
        entity.setUser(PerpustakaanApplication.getCurrentUser());
        return dao.save(entity);
    }

    @Transactional
    public Loan update(Loan enity){
        if (enity.getId() != null){
            Loan reference = getDao().findReference(enity.getId());

            reference.setReturnDate(enity.getReturnDate() != null
                    ? enity.getReturnDate()
                    : new Date());

            reference.setStatus(reference.getStatus().equals(Loan.StatusLoan.BORROWED)
            ? Loan.StatusLoan.RETURNED
            : reference.getStatus());

            enity.setLoanDate(reference.getLoanDate());
            enity.setReturnDate(reference.getReturnDate());
            enity.setStatus(reference.getStatus());

            return enity;
        }
        return null;
    }

    @Transactional
    public Collection<Loan> findByDate(Loan entity, Date startDate, Date endDate){
        Collection<Loan> result =dao.findByDate(entity, startDate, endDate);
        return result.size() > 0 ? result : new ArrayList<>();
    }
}
