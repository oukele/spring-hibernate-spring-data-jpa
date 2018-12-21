package com.oukele.the_data_jpa.service;

import com.oukele.the_data_jpa.dao.UserDao;
import com.oukele.the_data_jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findNameAndPassword(String name,String password){
        return userDao.findByNameAndPassword(name, password);
    }

}
