package com.company.controller;

import com.company.model.Salary;
import com.company.service.salary.SalaryServiceIMPL;

import java.util.List;

public class SalaryController {
    SalaryServiceIMPL salaryServiceIMPL =new SalaryServiceIMPL();
    public List<Salary> showListSalary(){
        return salaryServiceIMPL.findAllSalary();
    }
    public void createSalary(Salary salary){
        salaryServiceIMPL.saveSalary(salary);
    }
}
