package com.example.demo;

import org.springframework 
    .stereotype 
    .Repository; 
    
@Repository
  
// Class to create a list 
// of employees

public class EmployeeManager {
    private static Employees list 
        = new Employees(); 
  
    // This static block is executed 
    // before executing the main 
    // block 
    static
    { 
  
        // Creating a few employees 
        // and adding them to the list 
        list.getEmployeeList().add( new Employee( 1, "Michael", "Ogiri",  "michaelo1040@gmail.com", "Manager")); 
  
        list.getEmployeeList().add( new Employee(2, "Armani", "King", "kingarm888@gmail.com", "DevOps")); 
  
        list.getEmployeeList().add( new Employee(3, "Julio", "Cavares", "cavares2005@gmail.com", "Product Designer")); 
  
    } 
  
    // Method to return the list 
    public Employees getAllEmployees() 
    { 
  
        return list; 
    } 
  
        
        // Method to add an employee 
        // to the employees list 
        public void
        addEmployee(Employee employee) 
    { 
        list.getEmployeeList() 
            .add(employee); 
            
    }
}