package com.company.service.salary;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Salary;
import com.company.model.Staff;
import com.company.service.staff.StaffServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class SalaryServiceIMPL implements ISalaryService{
    StaffServiceIMPL staffServiceIMPL = new StaffServiceIMPL();
    public static String PATH ="D:\\MD2\\caseStudyMD2\\src\\com\\company\\data\\salary.txt";
    public static List<Salary> salaryList =new ConfigReadAndWriteFile<Salary>().readFromFile(PATH);


    @Override
    public List<Salary> findAllSalary() {
        return salaryList;
    }
    public void add(){
        new ConfigReadAndWriteFile<Salary>().writeToFile(PATH,salaryList);
    }
    @Override
    public void saveSalary(Salary salary) {
        salaryList.add(salary);
        add();
    }
}
