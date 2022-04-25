package com.company.service.user;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.User;

import java.io.IOException;
import java.util.List;

public class UserServiceIMPL implements IUserService{
public static String PATH ="D:\\MD2\\caseStudyMD2\\src\\com\\company\\data\\user.txt";
public static List<User> userList =new ConfigReadAndWriteFile<User>().readFromFile(PATH);
// show tên đăng kí
    @Override
    public List<User> showList()  {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
        return userList;
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }
// check đăng kí tồn tại không
    @Override
    public boolean existedByUserName(String userName) {
        for (int i = 0; i <userList.size(); i++) {
            if (userName.equals(userList.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }
// check đăng nhập
    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName())&&password.equals(userList.get(i).getPassWord())){
                return true;
            }
        }
        return false;
    }
}
