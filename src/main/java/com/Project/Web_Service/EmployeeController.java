package com.Project.Web_Service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Project.Web_Service.Employee;
import com.Project.Web_Service.EmployeeManager;
import com.Project.Web_Service.Employees;

@RestController
@RequestMapping(path = "/employees")

public class EmployeeController {

    // @Autowired
    private final EmployeeManager employeeManager;

     @Autowired
    public  EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping(
        path = "/",
        produces = "application/json"   
    )

    public Employees getEmployees() {
        return employeeManager.getAllEmployees();
    }



    @GetMapping(
        path = "/{id}",
        produces = "application/json"   
    )

    public Employee getEmployee(@PathVariable Integer id) {
        return employeeManager.getEmployee(id);
    }




    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json"    
    )

    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        Integer id = employeeManager
        .getAllEmployees()
        .getEmployeeList()
        .size()
         + 1;

         employee.setId(id);

         employeeManager.addEmployee(employee);

         URI location  = ServletUriComponentsBuilder
         .fromCurrentRequest()
         .path("/{id}")
         .buildAndExpand(employee.getId())
         .toUri();

         return ResponseEntity.created(location).build();
                     
                          
    }

    @PutMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json"
    )

    public ResponseEntity<Object> updateEmployee(@PathVariable Integer id , @RequestBody Employee updatedEmployee) {

        Employees updatedList = employeeManager.updateEmployee(id,updatedEmployee);

        if(updatedList != null) {
           return ResponseEntity.ok(updatedList);
        }
        else {
           return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(
         path = "/",
        consumes = "application/json",
        produces = "application/json"
    )

     public ResponseEntity<Object> deleteEmployee(@PathVariable Integer id ) {

        Employees updatedList = employeeManager.deleteEmployee(id);

        if(updatedList != null) {
           return ResponseEntity.ok(updatedList);
        }
        else {
           return ResponseEntity.notFound().build();
        }
    }


}

