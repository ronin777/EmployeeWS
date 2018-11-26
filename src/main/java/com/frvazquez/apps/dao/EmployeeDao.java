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

	public Boolean addEmployee(Employee employee);
	
	public List<Employee> getListEmployeeXName(String name);
}
