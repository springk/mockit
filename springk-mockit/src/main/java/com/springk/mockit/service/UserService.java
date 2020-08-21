package com.springk.mockit.service;

import com.springk.mockit.dao.UserDao;
import com.springk.mockit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    /**
     * DAO层
     */
    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名查询数据库，获取用户信息
     * @param name
     * @return User
     */
    public User getUserInfo(String name){
        return userDao.getByName(name);
    }

    /**
     * 根据用户名删除用户信息
     * @param name
     */
    public void deletByName(String name){
        userDao.deleteByName(name);
    }
}
