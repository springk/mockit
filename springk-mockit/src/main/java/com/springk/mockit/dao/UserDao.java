package com.springk.mockit.dao;

import com.springk.mockit.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {


    public User getByName(String name) {
        return new User();
    }

    public void deleteByName(String name){
        //doSomething
    }
}
