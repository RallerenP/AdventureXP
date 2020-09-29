package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.UserDTO;
import com.adventurealley.adventurexp.entities.Employee;
import com.adventurealley.adventurexp.repositories.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    IRepository userRepository;

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee updateEmployee() {
        return null;
    }

    @Override
    public Employee deleteEmployee() {
        return null;
    }

    @Override
    public Employee createEmployee(UserDTO userDto) {
        return null;
    }
}