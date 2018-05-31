package com.ar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ar.model.Employee;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Employee employee) {
		entityManager.persist(employee);
	}

	public Employee getEmpById(int id) {
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> getAllEmps() {
		return entityManager.createQuery("select emp.id,emp.name,emp.salary from Employee emp").getResultList();
	}

	public void delete(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	}

	public void update(Employee employee) {
		entityManager.merge(employee);
	}
}
