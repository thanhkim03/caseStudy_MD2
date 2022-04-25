package com.company.view;

import com.company.controller.UserController;
import com.company.model.User;
import com.company.service.user.UserServiceIMPL;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserView {
    Scanner scanner =new Scanner(System.in);
    List<User> userList = UserServiceIMPL.userList;
    UserController userController = new UserController();
    UserServiceIMPL userServiceIMPL =new UserServiceIMPL();
    public void add() throws IOException {
        System.out.println("────────ĐĂNG KÍ─────────");
        System.out.println("Nhập tên tài khoản đăng kí ");
        System.out.println("  Nhập không có dấu  ");
        String name;
        boolean checkName;
        while (true){
            name=scanner.nextLine();
            checkName=Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",name);
            if (!checkName){
                System.err.println("⚠️Tên đăng kí không hợp lệ ️");
                add();
            }else if (userServiceIMPL.existedByUserName(name)){
                System.err.println("⚠️Tên đăng kí bị trùng vui lòng nhập lại️");
            }else break;
        }
        System.out.println("Nhập mật khẩu đăng kí ");
        String pass = scanner.nextLine();
        boolean checkPass = Pattern.matches("[a-z0-9A-Z]{1,20}",pass);
        if (!checkPass){
            System.err.println("⚠️Mật khẩu không hợp lệ ️");
            add();
        }
        System.out.println("✔️Đăng kí thành công ");
        User user = new User(name,pass);
        userController.add(user);
            new LoginView();
    }
    public void login() throws IOException {
        System.out.println("─────────ĐĂNG NHẬP─────────");
        System.out.println("Nhập Tên ");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        User user = new User(name,pass);
        if (userController.login(user)){
            new Main();
        }else
            System.err.println("⚠️Tài khoản hoặc mật khẩu chưa đúng");
            new LoginView();
    }
//    public void showListUser() throws IOException {
//        System.out.println(userController.showListUser());
//    }
}
