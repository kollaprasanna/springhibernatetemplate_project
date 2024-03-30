package com.cyr.maven;

import java.util.List;

public interface EmployeeDao {
	public abstract void createEmployee(Employee employee);
	public abstract Employee fetchEmployeeById(Integer employeeId);
	public abstract List<Employee> fetchAllEmployees();
	public abstract void updateEmployeeEmailById(String newEmail,Integer employeeId);
	public abstract void deleteEmployeeById(Integer employeeId);
}

