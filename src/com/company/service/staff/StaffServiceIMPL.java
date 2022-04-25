package com.company.service.staff;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffServiceIMPL implements IStaffService {
    public static String PATH ="D:\\MD2\\caseStudyMD2\\src\\com\\company\\data\\staff";
    public static List<Staff> staffList =new ConfigReadAndWriteFile<Staff>().readFromFile(PATH);
//    show list
    @Override
    public List<Staff> findAll(){
        return staffList;
    }
//   thêm nhân viên mới
    public void add(){
    new ConfigReadAndWriteFile<Staff>().writeToFile(PATH,staffList);
}
//  lưu lại nhân viên mới
    @Override
    public void save(Staff staff){
        staffList.add(staff);
       add();
    }
//  xóa nhân viên
    @Override
    public void delete(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId()==id){
                staffList.remove(staffList.get(i));
                add();
            }
        }
    }
//  tìm nhân viên qua thời gian làm việc
    @Override
    public List<Staff> idWorkTime(int idWork) {
        List<Staff> staffArrayList =new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getWorkingTime()==idWork){
                staffArrayList.add(staffList.get(i));
            }
        }

        return staffArrayList;
    }
//  tìm kiếm nhân viên qua tên
    @Override
    public List<Staff> searchName(String name) {
        List<Staff> staffList1 =new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().equalsIgnoreCase(name)){
                staffList1.add(staffList.get(i));
            }
        }
        return staffList1;
    }
    //  sửa thông tin nhân viên
    @Override
    public void editStaff(int id, String name, int age, String sex, int status, int workingTime) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                staffList.get(i).setName(name);
                staffList.get(i).setAge(age);
                staffList.get(i).setSex(sex);
                staffList.get(i).setStatus(status);
                staffList.get(i).setWorkingTime(workingTime);
            }
        }
    }
}
