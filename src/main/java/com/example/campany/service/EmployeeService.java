package com.example.campany.service;


import java.util.List;

import com.example.campany.entities.Employee;


public interface EmployeeService {

	public void addEmployee(Employee em);
	public Employee updateEmployee(Employee em);
	public String deleteEmployee(int id_employee);
	public Employee getEmployee(int id_employee);
	public List<Employee> getAllEmployee();
	public void affectEmpToEnt(int idEnt, int idEmp);
	public void affectEmpToDept(int idDept, int idEmp);
}
