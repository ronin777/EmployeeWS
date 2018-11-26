
package com.frvazquez.apps.schema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employeeResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="employeeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="empstatusnewemployee" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="employees" type="{http://com.frvazquez.apps/schema}Employee" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employeeResponse", propOrder = { "empstatusnewemployee", "employees" })
public class EmployeeResponse {

    @XmlElement(required = true)
    protected String empstatusnewemployee;
    protected List<EmployeeSchema> employees;

    /**
     * Gets the value of the empstatusnewemployee property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEmpstatusnewemployee() {
        return empstatusnewemployee;
    }

    /**
     * Sets the value of the empstatusnewemployee property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEmpstatusnewemployee(String value) {
        this.empstatusnewemployee = value;
    }

    /**
     * Gets the value of the employees property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employees property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmployees().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmployeeSchema }
     *
     *
     */
    public List<EmployeeSchema> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<EmployeeSchema>();
        }
        return this.employees;
    }

}
