package com.Web_Service;

import org.springframework.stereotype.Repository;

import com.Web_Service.Employees;

@Repository

public class EmployeeDAO {

    private static Employees list = new Employees();

    static {

        list.getEmployeeList().add(
          new Employee(
              1,
             "Habte Selassie",
             "Fitsum",
              19,
             "habtuchelsea1000@gmail.com",
             "Software Engineer"
            ));


             list.getEmployeeList().add(
          new Employee(
              1,
             "Israel",
             "Fitsum",
              19,
             "israel@gmail.com",
             "Data Engineer"
            ));

             list.getEmployeeList().add(
          new Employee(
              1,
             "Bezawit",
             "Fitsum",
              19,
             "bezawit@gmail.com",
             "Software Engineer"
            ));


             list.getEmployeeList().add(
          new Employee(
              1,
             "Girum",
             "Fitsum",
              19,
             "habtuchelsea1000@gmail.com",
             "Software Engineer"
            ));

        list.getEmployeeList().add(
           new Employee(
             1,
             "Nathnael",
             "Getachew",
              19,
             "nati@gmail.com",
             "Waiter"
            ));
            
  
    }

    public Employees getAllEmployees() {
        return list;
    }


    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
