package com.cyr.maven;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class EmployeeDaoimpl implements EmployeeDao {
		 
		private HibernateTemplate hibernateTemplate;
		
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}
	 
		@Override
		public void createEmployee(Employee employee) {
			getHibernateTemplate().persist(employee);
		}
	 
		@Override
		public Employee fetchEmployeeById(Integer employeeId) {
			return getHibernateTemplate().get(Employee.class, employeeId);
	    }
		
		@Override
		public List<Employee> fetchAllEmployees() {
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Employee.class);
			List<Employee> employeeList = (List<Employee>) getHibernateTemplate().findByCriteria(detachedCriteria);
			return employeeList;
			}
		@Override
		public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
			Employee employee = getHibernateTemplate().get(Employee.class, employeeId);
			employee.setEmail(newEmail);
			getHibernateTemplate().update(employee);
		}
		@Override
		public void deleteEmployeeById(Integer employeeId) {
			Employee employee = getHibernateTemplate().get(Employee.class, employeeId);
			getHibernateTemplate().delete(employee);
		}
	}

