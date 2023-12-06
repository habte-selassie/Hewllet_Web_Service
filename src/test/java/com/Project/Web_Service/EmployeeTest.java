package com.Project.Web_Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class EmployeeTest {
    
    @Test
    public void testEmployeeToString () {
        // given
        Employee employee = new Employee(1,"Habte Selassie","Fitsum",180202,"Software Engineer","habdev0@gmail.com");

        // when 

        String toStringResult = employee.toString();

        //// then

        String expectedToString = "Employee [id = 1, firstName = Habte Selassie, lastName = Fitsum, employeeId = 180202 , title = Software Enginner, email = habdev0@gmail.com ]";

        Assertions.assertEquals(expectedToString,toStringResult);
    }

    @Test
    public void testSetterAndGetter() {
        // Given 

        Employee employee = new Employee(null, null, null, null, null, null);


        // when 

        employee.setId(1);
        employee.setFirstName("habte Selassie");
        employee.setLastName("Fitsum");
        employee.setEmployeeId(180202);
        employee.setTitle("Software Engineer");
        employee.setEmail("habdev0@gmail.com");
      

        // then 

        Assertions.assertEquals(1,employee.getId());
        Assertions.assertEquals("Habte Selassie",employee.getFirstName());
        Assertions.assertEquals("Fitsum",employee.getLastName());
        Assertions.assertEquals(180202,employee.getEmployeeId());
        Assertions.assertEquals("Software Engineer",employee.getTitle());
        Assertions.assertEquals("habdev@gmail.com",employee.getEmail());

    }
}
