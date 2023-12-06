package com.Project.Web_Service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.Project.Web_Service.Employees;

public class EmployeesTest {

    
    //  public List<Employee> employeeList;
   

    @Test
     public void testGetEmployeeList() {

        // given
        Employees employees = new Employees();

        // when
        List<Employee> employeeList = employees.getEmployeeList();

        // then
        Assertions.assertNotNull(employeeList, "The List is here so we can return the result");
        Assertions.assertTrue(employeeList.isEmpty(), "The employeeList should be empty initially");

        List <Employee> newEmployeeList = employees.getEmployeeList();
        Assertions.assertEquals(new ArrayList<>(), newEmployeeList, "The employeeList should be the same instance");
       
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
