package com.frvazquez.apps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.frvazquez.apps.dao.EmployeeDao;
import com.frvazquez.apps.entity.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	//Inicializacion Log
	Logger log = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public Boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

}
