package org.citecrud.service.dao;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.citecrud.DomainAwareBase;
import org.citecrud.model.Employee;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/persistence-beans.xml" })
public class EmployeeDaoTest extends DomainAwareBase {

	@Autowired
	// get rid of setter and getters through Autowire annotation
	private EmployeeDao employeeDao;

	private static Logger logger = Logger.getLogger(EmployeeDaoTest.class
			.getName());

	// add an employee, check the size of the lists
	// @Ignore

	@Test
	@Ignore
	public void testAdd() {
		int size = employeeDao.list().size();
		Employee employee = new Employee("testemployee", new Date());
		employeeDao.add(employee);

		// list should have one more employee now
		assertTrue(size < employeeDao.list().size());
		assertEquals(6, size);
	}

	@Test
	@Ignore
	public void testUpdate() {
		int size = employeeDao.list().size();
		// save
		Employee employee = new Employee("testemployee", new Date());
		employeeDao.add(employee);

		// update
		employee.setEmployeeName("updated");
		employeeDao.update(employee);

		Employee found = employeeDao.find(employee.getEmployeeId());
		assertEquals("updated", found.getEmployeeName());

	}

	@Test
	@Ignore
	public void testList() {
		assertEquals(0, employeeDao.list().size());
		List<Employee> employees = Arrays.asList(new Employee("test-1",
				new Date()), new Employee("test-2", new Date()), new Employee(
				"test-3", new Date()));
		for (Employee employee : employees) {
			employeeDao.add(employee);
		}

		List<Employee> found = employeeDao.list();
		assertEquals(3, found.size());
	}
	
	@Test
	public void testFind() {
		List<Employee> employees = employeeDao.findByName("P");
		assertEquals(3,employees.size());
		
		List<Employee> employeewithO = employeeDao.findByName("O");
		assertEquals("Oleg",employeewithO.get(0).getEmployeeName());
		
	}

	@Test
	@Ignore
	public void testAddSupervisor() {
		Employee manager1 = new Employee("A", new Date());

		Employee employee1 = new Employee("B", new Date());
		Employee employee2 = new Employee( "C", new Date());
		
		employee1.setSupervisor(manager1);
		employee2.setSupervisor(manager1);

		employeeDao.add(manager1);
		employeeDao.add(employee1);
		employeeDao.add(employee2);
		assertEquals(employee2.getSupervisor(), manager1);
	}
	
	@Test
	@Ignore
	public void testRemoveEmployee() {
		Employee greg = employeeDao.find(1);
		assertFalse(employeeDao.removeEmployee(greg));
	}

}
