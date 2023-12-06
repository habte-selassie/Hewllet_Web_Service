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
        Integer id =1;

        Employee employee = employeeManager.getEmployee(id);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(id,employee.getId());
        
    }




    @Test
    public void testGetEmployeeNonExistingId() {
        // Assuming the id doesn't exist in the employee list
        Integer nonExistingId = -1;
        
        // Your code that should throw an exception
        // For example, let's say you have a method that should throw an IllegalArgumentException
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            employeeManager.getEmployee(nonExistingId);
            throw new IndexOutOfBoundsException("This is a test exception");
        });
    }





     @Test
    public void testCreateEmployee() {
        // Assuming the employee  is created for the first time 
        Integer firstIdGiven = 7;

        Employee newEmployeeFirstTime = new Employee(firstIdGiven, "John", "Doe", 25, "john.doe@example.com", "Software Developer");
        
        Employees updatedDataByNewEmployees = employeeManager.createEmployee(newEmployeeFirstTime, newEmployeeFirstTime.getId());

        Assertions.assertNotNull(updatedDataByNewEmployees);

        Assertions.assertEquals(firstIdGiven,newEmployeeFirstTime.getId());
        
        // Assuming the employee  is created after the first time 
         

        Integer idThen = newEmployeeFirstTime.getId()+1;

        Employee newEmployeeThenTime = new Employee(idThen, "Gudmunduson", "Doyle", 28, "habtu.doe@example.com", "Devops Engineer");
        
        Employees updatedDataByThenEmployees = employeeManager.createEmployee(newEmployeeThenTime, newEmployeeThenTime.getId());

        Assertions.assertNotNull(updatedDataByThenEmployees);

        Assertions.assertEquals(idThen, newEmployeeThenTime.getId());

        
    }





      @Test
    public void testUpdateEmployee() {
         // Assuming there is some employee in the list 
        Integer id = 2;

         //Employee updatedEmployee = employeeManager.updateEmployee(2, null)

        Employee updatedEmployee = new Employee(2, "Yung", "Doe", 25, "john.doe@example.com", "Software Developer");
        
        Employees updatedEmployeeList = employeeManager.updateEmployee(id, updatedEmployee);

        Assertions.assertNotNull(updatedEmployeeList);
        Assertions.assertEquals(id,updatedEmployee.getId());

        Employee retrivedEmployee = updatedEmployeeList.getEmployeeList().get(id);

        Assertions.assertNotNull(retrivedEmployee);

        Assertions.assertEquals("Yung", retrivedEmployee.getFirstName());
        

    }


    @Test
    public void testUpdateEmployeeNonExistingId() {
        Integer id = -2;

        Employee updatedEmployee = new Employee(2, "Yung", "Doe", 25, "john.doe@example.com", "Software Developer");
        
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            employeeManager.updateEmployee(id, updatedEmployee);
            throw new IndexOutOfBoundsException("The id is out of bound");

        } );
      
        
    }


      @Test
    public void testDeleteEmployee() {
         // Assuming the employee  is existed
          Integer id = 2;
         ////////// size of list orginally after delete
          Integer orginalListBeforeDelete = employeeManager.getAllEmployees().getEmployeeList().size();

          employeeManager.deleteEmployee(id);
         ////////// size of list after delete
          Integer updatedListAfterDeleted = employeeManager.getAllEmployees().getEmployeeList().size();

          ////////// checking if the orginal list after deleted equal to updatedList
          Assertions.assertEquals(orginalListBeforeDelete-1, updatedListAfterDeleted);
           
      }


    @Test
    public void testDeleteEmployeeNonExistingId() {
         // Assuming the employee  is not existed
        Integer id = -2;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            employeeManager.deleteEmployee(id);
            throw new IndexOutOfBoundsException("The id is out of bound");
         });
     }



}
