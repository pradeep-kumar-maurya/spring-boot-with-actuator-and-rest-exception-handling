package com.cap1.dao;

import java.util.List;

import com.cap1.bean.Employee;
import com.cap1.exception.IdNotFoundException;

public interface EmployeeDaoI {

	Employee getEmployeeDetails(int id);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	List<Employee> deleteEmployee(int id) throws IdNotFoundException;

	List<Object> fetchAllEmployees();

}

