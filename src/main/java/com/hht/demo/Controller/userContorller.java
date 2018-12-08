package com.hht.demo.Controller;

import com.hht.demo.Bean.User;
import com.hht.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class userContorller {
    @Autowired
    private userService userService;

    @RequestMapping("/user/loginuser")
    public boolean login(String username,String password,HttpSession session){
        if (userService.selectpass(username)==null){
            return false;
        }
        else if(userService.selectpass(username).equals(password)){
            session.setAttribute("username",username);
            System.out.println(session.getAttribute("username"));
            return true;
        }
        return false;
    }

    @RequestMapping("/user/insertuser")
    public boolean insertuser(User user){
        if(userService.selectpass(user.getUsername())==null){
            userService.insertuser(user);
            return true;
        }
        else{
            return false;
        }
    }

    @RequestMapping("/user/updateuser")
    public void updateuser(User user){
        userService.updateuser(user);
    }

}
