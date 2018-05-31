package com.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ar.dao.EmployeeDaoImpl;
import com.ar.model.Employee;

@Controller
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	private void createEmployee(@RequestBody Employee employee) {
		employeeDaoImpl.create(employee);
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public Employee getEmployee(@PathVariable("id") int id) {
		return employeeDaoImpl.getEmpById(id);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public List<Employee> getAllEmployees() {
		return employeeDaoImpl.getAllEmps();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	public void delete(@PathVariable("id") int id) {
		employeeDaoImpl.delete(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void update(@RequestBody Employee employee) {
		employeeDaoImpl.update(employee);
	}
}
