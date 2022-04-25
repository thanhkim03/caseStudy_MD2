package com.company.model;

import java.io.Serializable;

public class Staff implements Serializable {
    public int id;
    public String name;
    public int age;
    public String sex;
    public int status;
    public int workingTime;

    public Staff(int id, String name, int age, String sex, int status, int workingTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.status = status;
        this.workingTime = workingTime;
    }

    public Staff() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }


    @Override
    public String toString() {
        return "Staff " +
                "id= " + id +
                ", name= " + name +
                ", age= " + age +
                ", sex= " + sex +
                ", status(1:Đang làm/2:Đã nghỉ)= " + status +
                ", workingTime(1:FullTime/2:PartTime)= " + workingTime +"\n";
    }
}
