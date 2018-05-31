package com.ar.dao;

import java.util.List;

import com.ar.model.Employee;

public interface EmployeeDao {

	public void create(Employee employee);

	public Employee getEmpById(int id);

	public List<Employee> getAllEmps();

	public void delete(int id);

	public void update(Employee employee);
}
