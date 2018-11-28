package com.frvazquez.apps.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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

	//Inicializacion Log
	Logger log = Logger.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	@Override
	public Boolean addEmployee(Employee employee) {
		boolean flagComplete = false;
		sessionFactory.getCurrentSession().save(employee);
		flagComplete = true;
		log.info("Registro guardado : "+flagComplete);
		return flagComplete;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getListEmployeeXName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.like("empName", "%"+name));
		return (List<Employee>) criteria.list();
	}


}
