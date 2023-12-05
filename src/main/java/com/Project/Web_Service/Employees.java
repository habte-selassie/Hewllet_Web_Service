package com.Project.Web_Service;

import java.util.List;

import com.Project.Web_Service.Employee;

import java.util.ArrayList;

public class Employees {


    public List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
       
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }

        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}