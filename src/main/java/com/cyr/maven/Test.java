package com.cyr.maven;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = null;
		try {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			EmployeeService employeeService = ctx.getBean(EmployeeSe
					rviceImpl.class);
			createEmployee(employeeService);
			getEmployeeById(employeeService);
			fetchAllEmployeesInfo(employeeService);
			employeeService.updateEmployeeEmailById("kk.cs2010@gmail.com", 1);
			employeeService.deleteEmployeeById(2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ctx != null)
				ctx.close();
		}
	}
 
	private static void fetchAllEmployeesInfo(EmployeeService employeeService) {
		employeeService.getAllEmployees().forEach(System.out::println);
	}
 
	private static void getEmployeeById(EmployeeService employeeService) {
		Employee employee = employeeService.getEmployeeById(1);
		System.out.println(employee);
	}
 
	private static void createEmployee(EmployeeService employeeService) {
		Employee employee = getEmployee() ;
		employeeService.createEmployee(employee);
	}
 
	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("KK");
		employee.setEmail("kk.m@gmail.com");
		employee.setGender("Male");
		employee.setSalary(95000.00);
		return employee;
	}


	}


