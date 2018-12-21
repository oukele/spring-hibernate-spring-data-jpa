package com.oukele.the_data_jpa.service;

import com.oukele.the_data_jpa.dao.UserDao;
import com.oukele.the_data_jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    
    @Autowired
    private UserDao userDao;// userDao可以实现 JpaRepository接口中 一些已经写好的方法
    
    public User findNameAndPassword(String name,String password){
        //这个是 驼峰命名法 来定义规则的get 和 find 代表 sql 里的 select By 代表 select 后面的条件 Name 并且 Password   (参数1，参数2 ) 
        return userDao.findByNameAndPassword(name, password);
    }

}
