package com.frvazquez.apps.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frvazquez.apps.entity.Employee;

/**
 * 
 * @author Fredy Vazquez
 * @FechaCreacion 21/11/2018
 *
 */
@Repository
public interface EmployeeDao {

	public List<Employee> getAllEmployee();

	public Employee addEmployee(Employee employee);

	public void deleteEmployee(Employee employee);

	public Employee getByIdEmployee(Long id);
	
}
