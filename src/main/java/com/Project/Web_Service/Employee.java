package com.Project.Web_Service;

public class Employee {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer employeeID;
    private String email;
    private String title;


    public Employee () {}

    public Employee (  Integer id, String firstName, String lastName, 
    Integer employeeID, String email, String title) {

        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.email = email;
        this.title = title;
                        

    }

    public String toString() {
        return "Employee ["
         + "id = " + id +","
         + "firstName = " + firstName +","
         + "lastName = " + lastName +","
         + "employeeID = " + employeeID +","
         + "email = " + email +","
         + "title = " + title +","
         + "]";
       
    }

    public Integer geId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     public Integer getEmployeeId() {
        return employeeID;
    }

    public void setEmployeeId(Integer employeeID) {
        this.employeeID = employeeID;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return null;
    }


}