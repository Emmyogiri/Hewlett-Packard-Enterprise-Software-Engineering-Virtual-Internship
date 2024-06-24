package com.example.demo;

// Creating an entity Employee 
public class Employee { 
  
    public Employee() {} 
  
    // Parameterized Constructor 
    // to assign the values 
    // to the properties of 
    // the entity 
     public Employee( 
        Integer id, String firstName, 
        String lastName, String email, String title) 
    { 
  
        super(); 
  
        this.id = id; 
  
        this.firstName = firstName; 
  
        this.lastName = lastName; 
  
        this.email = email;

        this.title = title;
  
            
    } 
  
       private Integer id; 
  
       private String firstName; 
  
       private String lastName; 
  
       private String email; 

       private String title;
  
    // Overriding the toString method 
    // to find all the values 
    @Override
   public String toString() 
    { 
  
        return "Employee [id="
            + id + ", firstName="
            + firstName + ", lastName="
            + lastName + ", email="
            + email + ", title="
            + title + "]"; 
  
            
    } 
  
    // Getters and setters of 
    // the properties 
    public Integer getId() 
    { 
  
         return id; 
    } 
  
    public void setId(Integer id) 
    { 
  
         this.id = id; 
    } 
  
    public String getFirstName() 
    { 
  
         return firstName; 
    } 
  
    public void setFirstName( 
        String firstName) 
    { 
  
         this.firstName = firstName; 
    } 
  
    public String getLastName() 
    { 
  
         return lastName; 
    } 
  
    public void setLastName( 
        String lastName) 
    { 
  
         this.lastName = lastName; 
    } 
  
    public String getEmail() 
    { 
  
         return email; 
    } 
  
    public void setEmail(String email) 
    { 
  
         this.email = email; 
    }
    
    public String getTitle() 
    { 
  
         return title; 
    } 
  
    public void setTitle(String title) 
    { 
  
         this.title = title; 
    }
}