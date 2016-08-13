package org.citecrud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.citecrud.model.Employee;
import org.citecrud.service.SupervisorService;
//import org.citecrud.service.SupervisorServiceTest;

import org.citecrud.service.dao.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class SupervisorServiceImpl implements SupervisorService {

	private SessionFactory sessionFactory;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();

	}

	private static Logger logger = Logger.getLogger(SupervisorServiceImpl.class
			.getName());

	@Override
	public List<Employee> subordinatesForSupervisor(Employee e) {
		List<Employee> allEmployees = employeeDao.list();
		// logger.info("" + allEmployees.size());
		List<Employee> subordinatesPerSupervisor = new ArrayList<Employee>();
		for (Employee employee : allEmployees) {
			// logger.info("Test " +e.equals(employee.getSupervisor()));
			// logger.info("Supervisor" + e.toString());
			if (e.equals(employee.getSupervisor())) {
				subordinatesPerSupervisor.add(employee);

			}

		}

		return subordinatesPerSupervisor;
	}

}
