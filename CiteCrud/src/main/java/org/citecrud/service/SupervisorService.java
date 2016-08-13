package org.citecrud.service;

import java.util.List;

import org.citecrud.model.Employee;

public interface SupervisorService {
	
	/**
	 * Finds all the subordinates for employee.
	 * 
	 * @param e
	 *            Employee
	 * 
	 * @return Employees
	 */

	List<Employee> subordinatesForSupervisor(Employee e);

	

}
