package com.fahruzydow.perpustakaan.service;

import com.fahruzydow.perpustakaan.common.RestResult;
import com.fahruzydow.perpustakaan.common.StatusCode;
import com.fahruzydow.perpustakaan.dao.BaseDao;
import com.fahruzydow.perpustakaan.dao.UserDao;
import com.fahruzydow.perpustakaan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService extends BaseService<User> {
   @Autowired
   private UserDao dao;

   @Autowired
   private JwtTokenService jwtTokenService;

    @Override
    protected BaseDao<User> getDao() {
        return dao;
    }

    @Transactional
    public User register(User param, User.Role role){
        User reference = dao.findOne(new User(param.getUsername()));

        if(reference != null){
            return null;
        }else{
            param.setRole(role);
            param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

            dao.save(param);
            return param;
        }
    }

    @Transactional
    public RestResult login(User param){
        RestResult result = new RestResult(StatusCode.PASSWORD_OR_USER_NOT_REGISTERED);

        User currentUser = dao.findOne(param);

        if (currentUser == null){
            return result;
        }else if(currentUser.getPassword() != null && BCrypt.checkpw(param.getPassword(), currentUser.getPassword())){
            UserDetails userDetails = new  org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

        currentUser.setToken(jwtTokenService.generateToken(userDetails));
        result.setData(currentUser);
        result.setStatus(StatusCode.LOGIN_SUCCESS);
        }else{
            result.setStatus(StatusCode.LOGIN_FAILED);
        }
        return result;
    }
}
