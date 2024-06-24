package com.example.demo;

import com.example.demo.Employee;
import com.example.demo.Employees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    @Test
    public void testGetEmployees() {
        Employees employees = employeeManager.getAllEmployees();
        assertNotNull(employees);
        assertEquals(3, employees.getEmployeeList().size());
    }

    @Test
    public void testAddEmployee() {
        Employee newEmployee = new Employee(4, "Alice", "Williams", "alice.williams@example.com", "Architect");
        employeeManager.addEmployee(newEmployee);
        
        Employees employees = employeeManager.getAllEmployees();
        assertEquals(4, employees.getEmployeeList().size());
        assertTrue(employees.getEmployeeList().stream().anyMatch(e -> e.getId().equals(4)));
    }
}