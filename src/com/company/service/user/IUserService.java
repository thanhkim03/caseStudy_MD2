package com.company.service.user;

import com.company.model.User;

import java.io.IOException;
import java.util.List;

public interface IUserService {
    List<User> showList() throws IOException;
    void add(User user) throws IOException;
    boolean existedByUserName(String userName);
    boolean checkLogin(String username, String password);
}
