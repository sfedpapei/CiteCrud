package org.citecrud.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.text.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer employeeId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_dateofhire")
	private Date employeeDateOfHire;

	@ManyToOne
	@JoinColumn(name = "employee_supervisor")
	private Employee supervisor;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "supervisor")
	@Fetch(FetchMode.SELECT)
	private List<Employee> subordinates = new ArrayList<Employee>();
	
	public Employee() {
		
	}

	public Employee(String employeeName, Date employeeDateOfHire, Employee ...employees) {
		this.employeeName = employeeName;
		this.employeeDateOfHire = employeeDateOfHire;
		subordinates.addAll(Arrays.asList(employees));
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDateOfHire() {
		return new SimpleDateFormat("dd-MM-yyyy").format(employeeDateOfHire);
	}

	public void setEmployeedateOfHire(Date employeedateOfHire) {
		this.employeeDateOfHire = employeeDateOfHire;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result
				+ ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime
				* result
				+ ((employeeDateOfHire == null) ? 0 : employeeDateOfHire
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeDateOfHire == null) {
			if (other.employeeDateOfHire != null)
				return false;
		} else if (!employeeDateOfHire.equals(other.employeeDateOfHire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", employeeDateOfHire=" + employeeDateOfHire
				+ ", supervisor=" + supervisor +  "]";
	}

}
