package com.Web_Service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Web_Service.Employee;
import com.Web_Service.EmployeeDAO;
import com.Web_Service.Employees;

@RestController
@RequestMapping(path = "/employees")

public class EmployeeController {

    // @Autowired
    private final EmployeeDAO employeeDAO;

     @Autowired
    public  EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping(
        path = "/",
        produces = "application/json"   
    )

    public Employees getEmployees() {
        return employeeDAO.getAllEmployees();
    }


    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json"    
    )

    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        Integer id = employeeDAO
        .getAllEmployees()
        .getEmployeeList()
        .size()
         + 1;

         employee.setId(id);

         employeeDAO.addEmployee(employee);

         URI location  = ServletUriComponentsBuilder
         .fromCurrentRequest()
         .path("/{id}")
         .buildAndExpand(employee.geId())
         .toUri();

         return ResponseEntity.created(location).build();
                     
                          
    }
}

