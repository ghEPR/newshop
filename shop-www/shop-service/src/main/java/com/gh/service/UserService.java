package com.gh.service;

import com.gh.dao.UserDao;
import com.gh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    public User findById(Integer id){
        return userDao.findById(id);
    }

}
