package com.company.service.salary;

import com.company.model.Salary;
import com.company.model.Staff;

import java.util.List;

public interface ISalaryService {
     List<Salary> findAllSalary();
     void saveSalary(Salary salary);
}
