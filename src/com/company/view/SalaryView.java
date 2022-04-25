package com.company.view;

import com.company.controller.SalaryController;
import com.company.model.Salary;
import com.company.model.Staff;
import com.company.service.staff.StaffServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class SalaryView {
    SalaryController salaryController =new SalaryController();
    Scanner scanner =new Scanner(System.in);
    public void showListSalary(){
        System.out.println(salaryController.showListSalary());
    }
    public void formCreateSalary() {
            List<Staff> staffList = new StaffServiceIMPL().staffList;
            for (int i = 0; i < staffList.size(); i++) {
                System.out.println("Staff: "+staffList.get(i).getName());
                System.out.println("nhập lương cơ bản ");
                int salary = scanner.nextInt();
                System.out.println("nhập số giờ làm thêm ");
                int overTime = scanner.nextInt();
                System.out.println("nhập số ngày nghỉ ");
                int dayOff = scanner.nextInt();
                Salary salary1 = new Salary(salary+(overTime*50000)-(dayOff*100000),overTime, dayOff);
                    System.out.println(staffList.get(i).getName());
                    System.out.println(salary1);
                }

    }
}
