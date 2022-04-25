package com.company.controller;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Staff;
import com.company.model.User;
import com.company.service.user.UserServiceIMPL;

import java.io.IOException;
import java.util.List;

public class UserController {
    UserServiceIMPL userServiceIMPL =new UserServiceIMPL();
    public List<User> showListUser()  {
        return userServiceIMPL.showList();
}
public void add(User user)  {
        userServiceIMPL.add(user);
        userServiceIMPL.showList();
}
public boolean login(User user){
        if(userServiceIMPL.checkLogin(user.getUserName(), user.getPassWord())){
            return true;
        } else {
            return false;
        }
}
}
