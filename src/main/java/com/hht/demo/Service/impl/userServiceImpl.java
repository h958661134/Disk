package com.hht.demo.Service.impl;

import com.hht.demo.Bean.User;
import com.hht.demo.Mapper.Usermapper;
import com.hht.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Autowired
    Usermapper usermapper;

    @Override
    public String selectpass(String username) {
        return usermapper.selectPass(username);
    }

    @Override
    public void insertuser(User user) {
        try {
            usermapper.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateuser(User user) {
        try {
            usermapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
