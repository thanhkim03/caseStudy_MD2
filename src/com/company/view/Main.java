package com.company.view;

import com.company.model.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() throws IOException {
        SalaryView salaryView =new SalaryView();
        Scanner scanner = new Scanner(System.in);
        StaffView staffView = new StaffView();
        SearchStaff searchStaff =new SearchStaff();
        System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆ QUẢN LÝ NHÂN VIÊN ▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");
        System.out.println("█               1. ✎ Thêm nhân viên                       █");
        System.out.println("█               2. \uD83D\uDCDD Danh sách nhân viên                  █");
        System.out.println("█               3. \uD83D\uDDD1 Xóa nhân viên                        █");
        System.out.println("█               4. \uD83D\uDD0E Tìm kiếm nhân viên                   █");
        System.out.println("█               5. \uD83D\uDD27 Sửa thông tin nhân viên              █");
        System.out.println("█               6. $ Tính lương nhân viên                 █");
        System.out.println("█               7. ↻ Đăng xuất                            █");
        System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");
        System.out.println("⫸");
        int chooseMenu = scanner.nextInt();
        switch (chooseMenu){
            case 1:
                staffView.formCreateStaff();
                break;
            case 2:
                staffView.showListStaff();
                break;
            case 3:
                staffView.deleteStaff();
                break;
            case 4:
                    System.out.println("======SEARCH=====");
                    System.out.println("1. \uD83D\uDD0E Tìm kiếm nhân viên làm theo giờ ");
                    System.out.println("2. \uD83D\uDD0E Tìm kiếm nhân viên theo tên ");
                    int search =scanner.nextInt();
                    switch (search){
                        case 1:
                            searchStaff.searchWorkingTime();
                            break;
                        case 2:
                            searchStaff.searchName();
                            break;
                }break;
            case 5:
                staffView.editStaff();
                break;
            case 6:
                salaryView.formCreateSalary();
                break;
            case 7:
                System.out.println("Cảm ơn bạn đã sửa dụng phần mềm quản lý nhân viên của tôi");
                System.out.println("❤️Nhớ đánh giá 5✫ nhé   ❤️");
                new LoginView();
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        // write your code here
        new Main();
    }
}
