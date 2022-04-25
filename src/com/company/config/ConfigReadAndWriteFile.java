package com.company.config;


import com.company.model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWriteFile<T> {
    public List<T> readFromFile(String path){
        List<T> staffList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            staffList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return staffList;
    }
    public void writeToFile(String path, List<T> staffList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(staffList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e){
            System.out.println(e.getMessage());;
        }
    }
}

