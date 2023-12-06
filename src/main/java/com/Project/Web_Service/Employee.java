package com.Project.Web_Service;

public class Employee {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer employeeID;
    private String title;
    private String email;


    public Employee () {}

    public Employee (  Integer id, String firstName, String lastName, 
    Integer employeeID, String title, String email) {

        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.title = title;
        this.email = email;
                        

    }

      @Override
     public String toString() {
     return "Employee ["
         + "id = " + id + ","
         + "firstName = " + firstName + ","
         + "lastName = " + lastName + ","
         + "employeeId = " + employeeID + ","
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

     

    public void setEmployeeId(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getEmployeeId() {
        return employeeID;
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