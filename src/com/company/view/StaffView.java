package com.company.view;

import com.company.controller.StaffController;
import com.company.model.Staff;
import com.company.service.staff.StaffServiceIMPL;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    List<Staff> staffList = StaffServiceIMPL.staffList;
    StaffController staffController = new StaffController();

    public void showListStaff() throws IOException {

        if (staffList.size()==0){
            System.out.println("Công ty ko có thành viên");
        }
        else  { System.out.println(staffController.showListStaff());
        }
        System.out.println("ấn end để về Menu");
        String back = scanner.nextLine();
        if (back.equalsIgnoreCase("end")) {
            new Main();
        }
    }

    public void formCreateStaff() throws IOException {

        while (true) {
            int id;
            if (staffList.size() == 0) {
                id = 1;
            } else {
                id = staffList.get(staffList.size() - 1).getId() + 1;
            }

            System.out.println("Họ và Tên : ");
            String name = scanner.nextLine();
            boolean checkName = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",name);
            if (!checkName){
                System.err.println("⚠️Tên không được bỏ trống và viết có dấu ️");
                  new Main();
            }

            System.out.println("Tuổi : ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Giới tính: ");
            String sex = scanner.nextLine();
            boolean checkSex = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",sex);
            if (!checkSex){
                System.err.println("⚠️Không hợp lệ ️");
                new Main();
            }

            System.out.println("Thời gian làm việc: ");
            System.out.println("1: FullTime \n2: PartTime");
            int workingTime = scanner.nextInt();
            switch (workingTime){
                case 1:
                    System.out.println("FullTime");
                    break;
                case 2:
                    System.out.println("PartTime");
                    break;
                default:
                    System.out.println("Chỉ nhập 1 hoặc 2");
                    formCreateStaff();
            }
            System.out.println("Trạng thái làm việc");
            System.out.println("1: Đang làm\n2: Đã nghỉ");
            int status =scanner.nextInt();
            switch (status) {
                case 1:
                    System.out.println("Đang làm");
                    break;
                case 2:
                    System.out.println("Đã nghỉ");
                    break;
                default:
                    System.out.println("Chỉ nhập 1 hoặc 2");
                    formCreateStaff();
            }
            scanner.nextLine();
            Staff staff = new Staff(id,name,age,sex,workingTime,status);
            staffController.createStaff(staff);
            System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("end")) {
                new Main();
            }
        }

    }
    public void deleteStaff() throws IOException {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập id nhân viên cần xóa: ");
            int id = scanner.nextInt();
            boolean check = false;
            for (int i = 0; i <staffList.size(); i++) {
                if(id==staffList.get(i).getId()){
                    check =true;
                }
            }
            if (check==false){
                System.out.println("id ko tồn tại");
                System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
                String back = scanner.nextLine();
                if (back.equalsIgnoreCase("end")) {
                    new Main();
                }
            }else {
                staffController.deleteStaff(id);
                System.out.println("Nhân viên có id= "+id+" đã được xóa");
            System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
            String back = scanner.next();
            scanner.nextLine();
            if (back.equalsIgnoreCase("end")) {
                new Main();
            }
            }
        }
    }
    public void editStaff() throws IOException {
        System.out.println("nhập id nhận viên bạn cần sửa ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check1= false;
        for (int i = 0; i <staffList.size(); i++) {
            if(id==staffList.get(i).getId()){
                check1 =true;
            }
        }
        if (check1==false){
            System.out.println("id ko tồn tại");
            System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
            String back = scanner.nextLine();
            if (back.equalsIgnoreCase("end")) {
                new Main();
            }
        }
        System.out.println("nhập tên mới,nhập skip néu không muốn thay đổi");
        String name =scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                if (name.equalsIgnoreCase("skip")){
                    name=staffList.get(i).getName();
                }
            }
        }  System.out.println("nhập tuổi,nhập số 0 néu không muốn thay đổi");
        int age = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                if (age==0){
                    age=staffList.get(i).getAge();
                }
            }
        }  System.out.println("nhập giới tính mới,nhập skip néu không muốn thay đổi");
        String sex =scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                if (sex.equalsIgnoreCase("skip")){
                    sex=staffList.get(i).getSex();
                }
            }
        }
        System.out.println("Thay đổi trạng thái làm việc, nhập 0 để không muốn thay đổi");
        System.out.println("0: Bỏ qua\n1: Đang làm\n2: Đã nghỉ");
        int status =scanner.nextInt();



        System.out.println("Nhập giờ làm mới");
        System.out.println("0: Skip\n1: FullTime\n2: PartTime");
        int workingTime =scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                if (workingTime==0){
                    workingTime=staffList.get(i).getWorkingTime();
                }
            }
        }
        staffController.editStaff1(id,name,age,sex,status,workingTime);
        System.out.println("Nhấn end để về menu");
        String back = scanner.next();
        scanner.nextLine();
        if (back.equalsIgnoreCase("end")) {
            new Main();
        }
    }

}
