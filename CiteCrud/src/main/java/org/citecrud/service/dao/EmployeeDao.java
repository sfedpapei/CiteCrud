package org.citecrud.service.dao;

import java.util.List;

import org.citecrud.model.Employee;
import org.citecrud.service.GenericDao;

public interface EmployeeDao extends GenericDao<Employee, Integer, String> {

	/**
	 * Tries to remove employee from the system.
	 * 
	 * @param employee
	 *            Employee to remove
	 * @return {@code true} if employee is not supervisor Else {@code false}.
	 */
	boolean removeEmployee(Employee employee);
	
	//boolean removeSupervisor(Employee employee);
	
	
}
