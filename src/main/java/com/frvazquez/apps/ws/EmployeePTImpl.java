package com.frvazquez.apps.ws;

import com.frvazquez.apps.schema.EmployeeRequest;
import com.frvazquez.apps.schema.EmployeeResponse;

import com.frvazquez.apps.schema.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "EmployeePT", targetNamespace = "http://com.frvazquez.apps/ws", serviceName = "EmployeeServices",
            portName = "EmployeePort", wsdlLocation = "/WEB-INF/wsdl/EmployeeServices.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ ObjectFactory.class })
public class EmployeePTImpl {
    public EmployeePTImpl() {
    }

    @WebResult(name = "employeeResponseElement", partName = "employeeResponse",
               targetNamespace = "http://com.frvazquez.apps/schema")
    @WebMethod(action = "http://com.frvazquez.apps/ws/employee")
    public EmployeeResponse employee(@WebParam(name = "employeeRequestElement", partName = "employeeRequest",
                                               targetNamespace = "http://com.frvazquez.apps/schema")
                                     EmployeeRequest employeeRequest) throws EmployeeExceptionMessage {
        return null;
    }
}
