package com.company.service.staff;

import com.company.model.Staff;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface IStaffService {
   List<Staff> findAll() throws IOException;
   void save (Staff staff) throws IOException;
   void delete(int id);
   List<Staff> idWorkTime(int id);
   List<Staff> searchName(String name);

   void editStaff(int id, String name, int age, String sex,int status, int workingTime);
//   sửa trạng thái làm việc
}
