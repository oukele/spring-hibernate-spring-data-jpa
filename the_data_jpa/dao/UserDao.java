package com.oukele.the_data_jpa.dao;

import com.oukele.the_data_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByNameAndPassword(String name,String password);
   
}
