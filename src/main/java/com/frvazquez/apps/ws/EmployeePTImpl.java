package com.frvazquez.apps.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.frvazquez.apps.entity.Employee;
import com.frvazquez.apps.schema.EmployeeRequest;
import com.frvazquez.apps.schema.EmployeeResponse;
import com.frvazquez.apps.schema.EmployeeSchema;
import com.frvazquez.apps.schema.ObjectFactory;
import com.frvazquez.apps.service.EmployeeService;

@WebService(name = "EmployeePT", targetNamespace = "http://com.frvazquez.apps/ws", serviceName = "EmployeeServices", portName = "EmployeePort", wsdlLocation = "/WEB-INF/wsdl/EmployeeServices.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ ObjectFactory.class })
public class EmployeePTImpl extends SpringBeanAutowiringSupport {

	Logger log = Logger.getLogger(EmployeePTImpl.class);

	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;

	public EmployeePTImpl() {
	}

	@WebResult(name = "employeeResponseElement", partName = "employeeResponse", targetNamespace = "http://com.frvazquez.apps/schema")
	@WebMethod(action = "http://com.frvazquez.apps/ws/employee")
	public EmployeeResponse employee(
			@WebParam(name = "employeeRequestElement", partName = "employeeRequest", targetNamespace = "http://com.frvazquez.apps/schema") EmployeeRequest employeeRequest)
			throws EmployeeExceptionMessage {

		EmployeeResponse employeeResponse = new EmployeeResponse();
		String action = employeeRequest.getAction();

		if (action.equals("a")) {

			Employee employee = new Employee();

			employee.setEmpAlias(employeeRequest.getEmpalias());
			employee.setEmpDni(employeeRequest.getEmpdni());
			employee.setEmpEmail(employeeRequest.getEmpemail());
			employee.setEmpName(employeeRequest.getEmpname());
			employee.setEmpPassword(employeeRequest.getEmppassword());

			boolean rspaAddEmployee = employeeService.addEmployee(employee);

			String statusAddEmployee = rspaAddEmployee == true ? "OK" : "NOT";
			employeeResponse.setEmpstatusnewemployee(statusAddEmployee);
			
		} else if (action.equals("1")) {

			List<Employee> listEmployee = new ArrayList<Employee>();

			listEmployee = employeeService.getAllEmployee();
			for (Employee emp : listEmployee) {
				EmployeeSchema employee = new EmployeeSchema();
				employee.setEmpalias(emp.getEmpAlias());
				employee.setEmpdni(emp.getEmpDni());
				employee.setEmpemail(emp.getEmpEmail());
				employee.setEmpname(emp.getEmpName());
				employee.setEmppassword(emp.getEmpPassword());

				employeeResponse.getEmployees().add(employee);

			}

		}

		return employeeResponse;
	}
}
