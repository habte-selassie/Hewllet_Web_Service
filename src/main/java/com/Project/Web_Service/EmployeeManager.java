package com.Project.Web_Service;

import org.springframework.stereotype.Repository;

import com.Project.Web_Service.Employees;
import com.Project.Web_Service.Employee;

@Repository

public class EmployeeManager {

    

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
         /////////////// check if employye exist
         if (list == null) {
             System.out.println("Employees never exist");
         }
        return  list;
    }

    public Employee getEmployee(Integer id) {
        /////////////// check if employee id is appropriate
         Employee singleEmployee = list.getEmployeeList().get(id);

        if( list == null || id < 0 || id > list.getEmployeeList().size()) {
              System.out.println("Employee never exist or multiple employees db never exist");
              return null;
        }

         else if (list.getEmployeeList().get(id) == null ) {
             System.out.println("Employee never exist");
         }
         return singleEmployee;
    }




     public Employees createEmployee(Employee employee, Integer id ) {
        /////////////// check if employye exist
        if (list == null) {
/////// if the list db is empty then u have to create a db and make its id to 1 or first
            list = new Employees();
            employee.setId(1);
            list.employeeList.add(employee);
        }
        // Check if id is within bounds
        else if (id < 0 || id > list.getEmployeeList().size()) {
            System.out.println("Invalid id for creating employee");
           
        } 
        /////// if some list db is there then u have to append a created  db and make its id after the previosu db

         else {
            Integer newId = list.getEmployeeList().size() + 1;
            employee.setId(newId);
            list.getEmployeeList().add(employee); 
            System.out.println("Invalid id for creating employee");
        }
        return list;
    }

     public Employees updateEmployee(Integer id, Employee updatedEmployee) {
         /////////////// check if employye exist
         if ( list == null || id < 0 || id > list.getEmployeeList().size()) {
             System.out.println("list is zero or the id of the db is less than zero or greater than db ");
             return null;
         }

        else if (list.getEmployeeList().get(id) == null) {
             System.out.println("Employe not found in the list");
         }

         else {

            list.getEmployeeList().set(id, updatedEmployee);
           
         }

         return list;
    }

     public Employees deleteEmployee(Integer id) {
         /////////////// check if employye exist
            if (list.getEmployeeList().get(id) == null) {
              System.out.println("Employee not found in the list");
          }

           else {
              list.getEmployeeList().remove((int) id);
           }
           return list;
    }

     


    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
