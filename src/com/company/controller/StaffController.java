package com.company.controller;

import com.company.model.Salary;
import com.company.model.Staff;
import com.company.service.salary.SalaryServiceIMPL;
import com.company.service.staff.IStaffService;
import com.company.service.staff.StaffServiceIMPL;

import java.io.IOException;
import java.util.List;

public class StaffController {

    StaffServiceIMPL staffServiceIMPL = new StaffServiceIMPL();
    public List<Staff> showListStaff() throws IOException{
        return staffServiceIMPL.findAll();
    }
    public void createStaff(Staff staff){
        staffServiceIMPL.save(staff);
    }
    public void deleteStaff(int id){
        staffServiceIMPL.delete(id);
    }
    public List<Staff> searchStaff(int idWorkTime){
       return staffServiceIMPL.idWorkTime(idWorkTime);
    }
    public List<Staff> searchName(String name){
        return staffServiceIMPL.searchName(name);
    }
    public void editStaff1(int id, String name, int age, String sex,int status, int workingTime){
        staffServiceIMPL.editStaff(id, name, age, sex,status, workingTime);
    }

}
