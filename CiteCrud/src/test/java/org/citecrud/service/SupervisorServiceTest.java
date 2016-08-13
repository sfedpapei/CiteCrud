package org.citecrud.service;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.citecrud.model.Employee;
import org.citecrud.service.dao.EmployeeDao;
import org.citecrud.service.dao.EmployeeDaoTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;



@ContextConfiguration(locations = { "/persistence-beans.xml" })
public class SupervisorServiceTest extends AbstractJUnit4SpringContextTests {
	private final String createScript = "src/main/resources/sql/create.sql";
	private final String deleteScript = "src/main/resources/sql/cleanup.sql";

	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private SupervisorService supervisorService;
	
	/*@Before
	public void insertData() {
		SimpleJdbcTestUtils.executeSqlScript(jdbcTemplate,
				new FileSystemResource(createScript), false);
	}*/

	/*@After
	public void cleanup() {
		SimpleJdbcTestUtils.executeSqlScript(jdbcTemplate,
				new FileSystemResource(deleteScript), false);
	}*/
	
	
	
	@Test
	public void testSubordinatesForSupervisor() {
		Employee greg = employeeDao.find(1);
		Employee aura = employeeDao.find(2);
		Employee oleg = employeeDao.find(3);

		assertEquals(4, supervisorService.subordinatesForSupervisor(greg).size());
		//assertEquals(1, supervisorService.subordinatesForSupervisor(aura).size());
		//assertEquals(greg.getEmployeeName(), "Greg");
		//assertEquals(aura.getSupervisor().getEmployeeId(), oleg.getEmployeeId());
	}

}
