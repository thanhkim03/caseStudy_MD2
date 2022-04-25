package com.company.model;

import java.io.Serializable;

public class Salary extends Staff implements Serializable {
    public int salary;
    public int overTime;
    public int dayOff;

    public Salary(int id, String name, int age, String sex, int status, int workingTime, int salary, int overTime, int dayOff) {
        super(id, name, age, sex, status, workingTime);
        this.salary = salary;
        this.overTime = overTime;
        this.dayOff = dayOff;
    }

    public Salary(int salary, int overTime, int dayOff) {
        this.salary = salary;
        this.overTime = overTime;
        this.dayOff = dayOff;
    }

    public Salary() {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    @Override
    public String toString() {
        return "salary= " + salary +
                ",overTime= " + overTime +
                ",dayOff= " + dayOff;
    }
}
