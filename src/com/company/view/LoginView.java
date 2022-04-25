package com.company.view;

import java.io.IOException;
import java.util.Scanner;

public class LoginView {
    public LoginView() throws IOException {
        System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");
        System.out.println("█ ==== QUAN LY NHAN VIEN === █");
        System.out.println("█        1. Đăng kí          █");
        System.out.println("█        2. Đăng nhập        █");
        System.out.println("█        3. Đánh giá         █");
        System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");
        System.out.print("⫸");
        Scanner sa =new Scanner(System.in);
        int hs = sa.nextInt();
        switch (hs){
            case 1:
                new UserView().add();
                break;
            case 2:
                new UserView().login();
                break;
            case 3:
                System.out.println("nhập 5 để đánh giá 5 ✪");
                int danhGia=sa.nextInt();
                switch (danhGia){
                    case 5:
                        System.out.println("     ✪ ✪ ✪ ✪ ✪");
                        System.out.println("cảm ơn bạn đã đánh giá");
                        new LoginView();
                        break;
                }
//            case 4:
//                new UserView().showListUser();
//                new LoginView();
//                break;

        }
    }

    public static void main(String[] args) throws IOException {
        new LoginView();
    }
}
