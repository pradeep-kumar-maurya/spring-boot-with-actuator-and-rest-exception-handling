package com.cap1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap1.bean.Employee;
import com.cap1.exception.IdNotFoundException;
import com.cap1.exception.IncorrectIdException;
import com.cap1.service.EmployeeServiceI;

@RestController
@CrossOrigin("http://localhost:4200")
public class MyController {
	@Autowired
	private EmployeeServiceI service;

	// fetch particular employee details
	@GetMapping("/getEmployeeDetails/{enter Employee id here}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable ("enter Employee id here") int id) throws IdNotFoundException{
		Employee emp =   service.getEmployeeDetails(id);
		if(emp == null) {
			throw new IdNotFoundException("Expmoyee with ID : "+id+" does not exist");
		}
		else {
			ResponseEntity<Employee>responseEntity = new ResponseEntity<Employee>(emp, HttpStatus.OK); 
			return responseEntity;
		}
	}

	// create the employee
	@PostMapping("/createEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		employee = service.createEmployee(employee);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("the employee was created successfully", HttpStatus.OK);
		return responseEntity;
	}

	// update the employee
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws  IncorrectIdException {
		Employee emp = service.updateEmployee(employee);
		if(emp != null) {
			ResponseEntity<String> responseEntity =  new ResponseEntity<String>("Employee details were updated successfully!!",HttpStatus.OK);
			return responseEntity;
		}
		else {
			throw new IncorrectIdException("Sorry, Employee with ID : "+employee.getEid()+" does not exist !!");
		}
	}

	//delete the employee
	@DeleteMapping("/deleteEmployee/{id}")
	public  List<Employee> deleteEmployee(@PathVariable ("id") int id) throws IdNotFoundException {
		List<Employee> list = service.deleteEmployee(id);
		return list;
	}

	//fetch all employees
	@GetMapping("/fetchAllEmployees")
	public List<Object>fetchAllEmployees(){
		List <Object>list = service.fetchAllEmployees();
		return list;
	}
}
