package com.company.view;

import com.company.controller.StaffController;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchStaff {
    Scanner scanner =new Scanner(System.in);
    StaffController staffController =new StaffController();
    public void searchWorkingTime() throws IOException {
        while (true){
            System.out.println("Nhập vào trạng thái cần tìm ");
            System.out.println("1. FullTime \n2. PartTime");
            int idWork =scanner.nextInt();
            System.out.println( staffController.searchStaff(idWork));
            System.out.println("Nhấn end để về menu hoặc nhập phím bất kì để tiếp tục");
            scanner.nextLine();
            String back = scanner.nextLine();
            if (back.equalsIgnoreCase("end")) {
                new Main();
            }
        }
    }
    public void searchName() throws IOException {
        while (true){
            System.out.println("Nhập tên nhân viên cần tìm kiếm ");
            String name =scanner.nextLine();
            boolean checkName = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",name);
            if (!checkName){
                System.err.println("Chưa nhập tên !!!");
                new Main();
            }
            System.out.println(staffController.searchName(name));
            System.out.println("Nhấn end để về menu hoặc nhập phím bất kì để tiếp tục");
            String backOut = scanner.nextLine();
            if (backOut.equalsIgnoreCase("end")) {
                new Main();
            }
        }
    }
}
