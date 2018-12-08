package com.hht.demo.Mapper;

import com.hht.demo.Bean.User;

import java.util.List;

public interface Usermapper {
    /*
    * 用户注册
    * */
    public void insertUser(User user) throws Exception;

    /*
    * 修改用户密码
    * */
    public void updateUser(User user) throws Exception;

    /*
    * 查询用户信息
    * */
    public List<User> selectUser() throws Exception;

    /*
    * 用户登录
    * */
    public String selectPass(String password);
}
