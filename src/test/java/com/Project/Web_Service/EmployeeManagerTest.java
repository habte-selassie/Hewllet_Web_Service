package com.Project.Web_Service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class EmployeeManagerTest {
    
    private EmployeeManager employeeManager;

    @BeforeEach
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    @Test
    public void testGetAllEmployees() {
        Employees allEmployees = employeeManager.getAllEmployees();
        Assertions.assertNotNull(allEmployees);
        Assertions.assertNotNull(allEmployees.getEmployeeList());
        Assertions.assertFalse(allEmployees.getEmployeeList().isEmpty());
    }

    @Test
    public void testGetEmployee() {
        // Assuming the id exists in the employee list
        Integer id =0;

        Employee employee = employeeManager.getEmployee(id);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(id,employee.getId());
        
    }

    @Test
    public void testGetEmployeeNonExistingId() {
        // Assuming the id doesn't exist in the employee list
        Integer id = -1;
        Employee employee = employeeManager.getEmployee(id);
        Assertions.assertNull(employee);
    }

     @Test
    public void testCreateEmployee() {
         // Assuming the employee creation is successful
        Employee newEmployee = new Employee(2, "John", "Doe", 25, "john.doe@example.com", "Software Developer");
        
        Employees updatedDataByNewEmployees = employeeManager.createEmployee(newEmployee, newEmployee.getId());

        Assertions.assertNotNull(updatedDataByNewEmployees);
        Assertions.assertEquals(2,updatedDataByNewEmployees.getEmployeeList().size());
        
    }


      @Test
    public void testUpdateEmployee() {
         // Assuming the employee creation is successful
        Employee newEmployee = new Employee(2, "John", "Doe", 25, "john.doe@example.com", "Software Developer");
        
        Employees updatedDataByNewEmployees = employeeManager.createEmployee(newEmployee, newEmployee.getId());

        Assertions.assertNotNull(updatedDataByNewEmployees);
        Assertions.assertEquals(2,updatedDataByNewEmployees.getEmployeeList().size());
        
    }


      @Test
    public void testDeleteEmployee() {
         // Assuming the employee creation is successful
        Employee newEmployee = new Employee(2, "John", "Doe", 25, "john.doe@example.com", "Software Developer");
        
        Employees updatedDataByNewEmployees = employeeManager.createEmployee(newEmployee, newEmployee.getId());

        Assertions.assertNotNull(updatedDataByNewEmployees);
        Assertions.assertEquals(2,updatedDataByNewEmployees.getEmployeeList().size());
        
    }






}
