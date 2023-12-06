package com.Project.Web_Service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.Project.Web_Service.Employees;

public class EmployeesTest {

    
     public List<Employee> employeeList;
   

    @Test
     public void testGetEmployeeList() {

        // given
        Employees employees = new Employees();

        // when
        List<Employee> employeeList = employees.getEmployeeList();

        List <Employee> newEmployeeList = new ArrayList<>();
        

        // then
        Assertions.assertNotNull(employeeList, "The List is here so we can return the result");
        Assertions.assertNull(newEmployeeList, "The List is empty so create an arraylist so we can return the result");

    }

    @Test
    public void testSetEmployeeList() {
        // given 
        Employees employees = new Employees();

        List <Employee> newEmployeeList = new ArrayList<>();

        // when 
         employees.setEmployeeList(newEmployeeList);

        // then 
       List<Employee> retrivedList = employees.getEmployeeList();
       Assertions.assertSame(newEmployeeList,retrivedList,"The Lists are the same");
    }
    


    
}
