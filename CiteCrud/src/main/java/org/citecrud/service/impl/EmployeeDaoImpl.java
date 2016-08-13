package org.citecrud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.citecrud.model.Employee;
import org.citecrud.service.SupervisorService;
import org.citecrud.service.dao.EmployeeDao;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.hibernate.Query;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("employeeDao")
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class EmployeeDaoImpl extends HibernateDao<Employee, Integer, String> implements
		EmployeeDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	private SupervisorService supervisorService;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();

	}

	public List<Employee> list() {
		return currentSession().createCriteria(Employee.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	private static Logger logger = Logger.getLogger(EmployeeDaoImpl.class
			.getName());

	@Override
	//@Transactional
	public boolean removeEmployee(Employee employee) {
		List<Employee> subordinates = supervisorService.subordinatesForSupervisor(employee);
		if (subordinates.size() >0) {
			return false;
		}
		 
		remove(employee);
		return false;
	}

	@Override
	public List<Employee> findByName(String name) {
		Query findEmployeeByName = currentSession().createQuery("from Employee e where e.employeeName like:employeeName ");
		findEmployeeByName.setParameter("employeeName", "%"+name+"%");
		return findEmployeeByName.list();
	}

}
