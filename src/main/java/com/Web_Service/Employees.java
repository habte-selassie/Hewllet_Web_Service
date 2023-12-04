package com.Web_Service;

import java.util.List;
import java.util.ArrayList;
import com.Web_Service.Employee;

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