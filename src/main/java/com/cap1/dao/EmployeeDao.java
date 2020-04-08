package com.cap1.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cap1.bean.Employee;
import com.cap1.exception.IdNotFoundException;

@Repository
public class EmployeeDao implements EmployeeDaoI{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee getEmployeeDetails(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employee = entityManager.merge(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp = entityManager.find(Employee.class, employee.getEid());
		if( emp != null) {
			emp.setEname(employee.getEname());
			emp.setEsal(employee.getEsal());
			entityManager.merge(emp);
			return emp;
		}
		else {
			return emp;
		}
	}

	@Override
	public List<Employee> deleteEmployee(int id) throws IdNotFoundException {
		Employee emp = entityManager.find(Employee.class, id);
		if( emp == null ) {
			throw new IdNotFoundException("Employee with ID : "+id+" does not exist");
		}
		else {
			entityManager.remove(emp);
			Query query = entityManager.createQuery("select e from Employee e");
			List<Employee> list = query.getResultList();
			return list;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> fetchAllEmployees() {
		Query query = entityManager.createQuery("select e from Employee e");
		List<Object> list = query.getResultList();
		return list;
	}

}

