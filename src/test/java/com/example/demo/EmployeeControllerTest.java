package com.example.demo;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeManager employeeManager;

    private Employees employees;

    @BeforeEach
    void setUp() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setEmail("Johndoe@gmail.com");
        employee1.setTitle("Accountant");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFirstName("Jane");
        employee2.setLastName("Smith");
        employee2.setEmail("Janesmith@gmail.com");
        employee2.setTitle("Chief Technology Officer");

        employees = new Employees();
        employees.setEmployeeList(Arrays.asList(employee1, employee2));
    }

    @Test
    void testGetEmployees() throws Exception {
        when(employeeManager.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeList.length()").value(2))
                .andExpect(jsonPath("$.employeeList[0].id").value(1))
                .andExpect(jsonPath("$.employeeList[1].id").value(2));
    }

    @Test
    void testAddEmployee() throws Exception {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Alice");

        when(employeeManager.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newEmployee)))
                .andExpect(status().isCreated());

        verify(employeeManager, times(1)).addEmployee(any(Employee.class));
    }
}
