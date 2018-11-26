package com.frvazquez.apps.service;

import java.util.List;

import com.frvazquez.apps.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Boolean addEmployee(Employee employee);

	public List<Employee> getListEmployeeXName(String name);

}
