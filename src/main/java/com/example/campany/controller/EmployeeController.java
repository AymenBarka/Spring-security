package com.example.campany.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.campany.entities.Departement;
import com.example.campany.entities.Employee;
import com.example.campany.entities.Entreprise;
import com.example.campany.service.DepartementService;
import com.example.campany.service.EmployeeService;
import com.example.campany.service.EntrepriseService;


@CrossOrigin(origins="http://localhost:4200/")

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	DepartementService departementService;
	
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
		
	}
	
	@GetMapping("/listEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/listEmployee/{id}")
	public ResponseEntity<Employee>  getEmployee(@PathVariable(value="id") int empid) {
		Employee emp = employeeService.getEmployee(empid);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee  updateEmployee(@RequestBody Employee employee) {
		
		

		return employeeService.updateEmployee(employee);
			
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable(value="id") int id_employee) {
		 return employeeService.deleteEmployee(id_employee)	;
	}
	
    @GetMapping("/affectEmployee/{idEmp}/{idEnt}")
	public void affectEmpToEnt(@PathVariable(value="idEnt") int idEnt ,@PathVariable(value="idEmp") int idEmp) {
		employeeService.affectEmpToEnt(idEnt, idEmp);
	}
    
    @GetMapping("/affectEmployeeDepartement/{idEmp}/{idDept}")
	public void affectEmpToDept(@PathVariable(value="idDept") int idDept ,@PathVariable(value="idEmp") int idEmp) {
		employeeService.affectEmpToDept(idDept, idEmp);
	}


}
