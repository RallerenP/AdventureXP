package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.UserDTO;
import com.adventurealley.adventurexp.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee();
    public Employee deleteEmployee();
    public Employee createEmployee(UserDTO userDto);

}
