package org.citecrud.web;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.citecrud.model.Employee;
import org.citecrud.service.dao.EmployeeDao;
import org.citecrud.service.impl.SupervisorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/employees")
public class EmployeeController {

	private static Logger logger = Logger.getLogger(SupervisorServiceImpl.class
			.getName());

	@Autowired
	private EmployeeDao employeeDao;

	/*
	 * @RequestMapping(value = "/employees", method = RequestMethod.GET) public
	 * String showEmployees(Model model) { List<Employee> employees =
	 * employeeDao.list(); model.addAttribute("employees", employees); return
	 * "employees/list"; }
	 */

	@RequestMapping(value = "/employees/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("employee", new Employee());
		return "employees/findemployees";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String processFindForm(Employee employee, Map<String, Object> model) {
		if (employee.getEmployeeName() == null) {
			employee.setEmployeeName("");
		}

		List<Employee> results = employeeDao.findByName(employee
				.getEmployeeName());
		// logger.info("hi");
		if (results.isEmpty()) {
			return "employees/findemployees";
		} else {
			model.put("employees", results);
			return "employees/list";

		}

	}
	
	@RequestMapping("/employees/{employeeId}")
	public String showOwner (@PathVariable("employeeId") int employeeIdModel, Model model) {
		model.addAttribute("employee", employeeDao.find(employeeIdModel));
		return "employees/employeeDetails";
		
	}

}
