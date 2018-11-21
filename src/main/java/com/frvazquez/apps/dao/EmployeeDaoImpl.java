package com.frvazquez.apps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.frvazquez.apps.entity.Employee;


/**
 * 
 * @author Fredy Vazquez
 * @FechaCreacion 21/11/2018
 *
 */
@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getAllEmployee() {
		String query = "FROM employee as emp ORDER BY emp.empName";
		return (List<Employee>) entityManager.createQuery(query).getResultList();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		entityManager.persist(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		entityManager.remove(employee);
	}

	@Override
	public Employee getByIdEmployee(Long id) {
		return entityManager.find(Employee.class, id);
	}

}
