package com.Project.Web_Service;

public class Employee {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer employeeId;
    private String title;
    private String email;


    public Employee () {}

    public Employee (  Integer id, String firstName, String lastName, 
    Integer employeeId, String title, String email) {

        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.title = title;
        this.email = email;
                        

    }

      @Override
     public String toString() {
     return "Employee ["
         + "id = " + id + ","
         + "firstName = " + firstName + ","
         + "lastName = " + lastName + ","
         + "employeeId = " + employeeId + ","
         + "title = " + title + ","
         + "email = " + email +
         "]";
         }


     public void setId(Integer id) {
        this.id = id;
     }

    public Integer getId() {
        return id;
    }

   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }  

     public String getFirstName() {
        return firstName;
    }

    

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     public String getLastName() {
        return lastName;
    }

     

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
 

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public String getEmail() {
        return email;
    }
   


}