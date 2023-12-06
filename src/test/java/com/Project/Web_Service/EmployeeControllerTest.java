package com.Project.Web_Service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.Project.Web_Service.Employee;
import com.Project.Web_Service.EmployeeController;
import com.Project.Web_Service.EmployeeManager;
import com.Project.Web_Service.Employees;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void testGetEmployees() throws Exception {
        // Mock the behavior of the EmployeeManager
        Employees mockEmployees = new Employees();
        Mockito.when(employeeManager.getAllEmployees()).thenReturn(mockEmployees);

        // Perform the GET request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().json("{\"employeeList\":[]}"));
    }

    @Test
    void testGetEmployee() throws Exception {
        // Mock the behavior of the EmployeeManager
        Integer id = 1;
        Employee mockEmployee = new Employee(id, "John", "Doe", 25, "john.doe@example.com", "Software Developer");
        Mockito.when(employeeManager.getEmployee(id)).thenReturn(mockEmployee);

        // Perform the GET request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/{id}", id))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"employeeId\":25,\"email\":\"john.doe@example.com\",\"title\":\"Software Developer\"}"));
    }

    @Test
    void testAddEmployee() throws Exception {
        // Mock the behavior of the EmployeeManager
        Employee newEmployee = new Employee(1, "Jane", "Doe", 26, "jane.doe@example.com", "Software Engineer");
        Mockito.when(employeeManager.getAllEmployees()).thenReturn(new Employees());

        // Perform the POST request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"employeeId\":26,\"email\":\"jane.doe@example.com\",\"title\":\"Software Engineer\"}")
        )
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/employees/1"));
    }

  @Test
void testUpdateEmployee() throws Exception {
    // Mock the behavior of the EmployeeManager
    Integer id = 1;
    Employee updatedEmployee = new Employee(id, "Jane", "Doe", 26, "jane.doe@example.com", "Software Engineer");
        // Assuming you have a method to add employees in your Employees class
    Employees existingEmployees = new Employees();
        
        // Create a list with the updated employee
    List<Employee> employeeList = Arrays.asList(updatedEmployee);

        // Set the employee list in existingEmployees
    existingEmployees.setEmployeeList(employeeList);
    Mockito.when(employeeManager.getAllEmployees()).thenReturn(existingEmployees);
    Mockito.when(employeeManager.updateEmployee(id, updatedEmployee)).thenReturn(existingEmployees);

    // Perform the PUT request and assert the response
    mockMvc.perform(MockMvcRequestBuilders.put("/employees/{id}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"employeeId\":26,\"email\":\"jane.doe@example.com\",\"title\":\"Software Engineer\"}")
    )
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().json("{\"employeeList\":[{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"employeeId\":26,\"email\":\"jane.doe@example.com\",\"title\":\"Software Engineer\"},{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"employeeId\":25,\"email\":\"john.doe@example.com\",\"title\":\"Software Developer\"}]}"));
}

    @Test
    void testDeleteEmployee() throws Exception {
        // Mock the behavior of the EmployeeManager
        Integer id = 1;
        Employees updatedList = new Employees();
        Mockito.when(employeeManager.deleteEmployee(id)).thenReturn(updatedList);

        // Perform the DELETE request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.delete("/employees/{id}", id))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().json("{\"employeeList\":[]}"));
    }
}
