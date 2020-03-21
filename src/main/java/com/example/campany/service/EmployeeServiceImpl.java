package com.example.campany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campany.entities.Departement;
import com.example.campany.entities.Employee;
import com.example.campany.entities.Entreprise;
import com.example.campany.repositories.DepartementRepository;
import com.example.campany.repositories.EmployeeRepository;
import com.example.campany.repositories.EntrepriseRepository;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public void addEmployee(Employee em) {
		employeeRepository.save(em);		
	}

	@Override
	public Employee updateEmployee(Employee em) {
		
		Employee existingEmp = employeeRepository.findById(em.getId_employee()).orElse(null);
		existingEmp.setNom(em.getNom());
		existingEmp.setPrenom(em.getPrenom());
		existingEmp.setDept(em.getDept());
		existingEmp.setEnt(em.getEnt());
		return employeeRepository.save(existingEmp);
		
	}

	@Override
	public String deleteEmployee(int id_employee) {
		Optional<Employee> empl = employeeRepository.findById(id_employee);
		if(empl.isPresent()) {
			employeeRepository.delete(empl.get());
			return "employee is deleted by id "+ id_employee;
		}
		
		throw new RuntimeException("Employee not found");
	}

	@Override
	public Employee getEmployee(int id_employee) {
		return employeeRepository.findById(id_employee).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	@Override
	public void affectEmpToEnt(int idEnt, int idEmp) {
		Employee emp = employeeRepository.findById(idEmp).get();
		Entreprise ent = entrepriseRepository.findById(idEnt).get();
		emp.setEnt(ent);
		List<Employee> liste = ent.getEmployees();
		liste.add(emp);
		ent.setEmployees(liste);
		employeeRepository.save(emp);
		entrepriseRepository.save(ent);
	}

	@Override
	public void affectEmpToDept(int idDept, int idEmp) {
       Employee empl = employeeRepository.findById(idEmp).get();
       Departement dept= departementRepository.findById(idDept).get();
       empl.setDept(dept);
       List<Employee> lists = dept.getEmployees();
       lists.add(empl);
       dept.setEmployees(lists);
       employeeRepository.save(empl);
       departementRepository.save(dept);
	}
	
}
