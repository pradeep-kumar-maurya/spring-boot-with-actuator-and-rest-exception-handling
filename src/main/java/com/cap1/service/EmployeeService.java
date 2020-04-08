package com.cap1.service;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap1.bean.Employee;
import com.cap1.dao.EmployeeDaoI;
import com.cap1.exception.IdNotFoundException;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceI {

	@Autowired
	private EmployeeDaoI dao;

	@Override
	public Employee getEmployeeDetails(int id) {
		return dao.getEmployeeDetails(id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return dao.createEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}

	@Override
	public List<Employee> deleteEmployee(int id) throws IdNotFoundException {
		return dao.deleteEmployee(id);
	}

	@Override
	public List<Object> fetchAllEmployees() {
		return dao.fetchAllEmployees();
	}
}
