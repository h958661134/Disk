package com.hht.demo.Service;

import com.hht.demo.Bean.User;

public interface userService {

    public String selectpass(String username);
    public void insertuser(User user);
//    public void deluser(String user);
    public void updateuser(User user);

}
