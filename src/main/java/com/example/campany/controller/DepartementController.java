package com.example.campany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.campany.service.DepartementService;
@CrossOrigin(origins="http://localhost:4200/")

@RestController
@RequestMapping(value = "/departements")
public class DepartementController {

	@Autowired
	DepartementService departementService;
	
	@PostMapping("/addDepartement")
	public void addDepartement(@RequestBody Departement departement) {
		departementService.addDepartement(departement);
	}
	
	@PutMapping("/updateDepartement/{id}")
	public Departement updateDepartement(@RequestBody Departement dep) {
		return departementService.updateDepartement(dep);
	}
	
	@GetMapping("/listDepartement/{id}")
	public Departement getDepartement(@PathVariable(value="id") int dep) {
		return departementService.getDepartement(dep);
	}
	
	@GetMapping("/listDepartement")
	public List<Departement> getAllDepartement() {
		return departementService.getAllDepartement();
	}
	
	@DeleteMapping("/deleteDepartement/{id}")
	public String deleteDepartement(@PathVariable(value="id") int dep) {
		return departementService.deleteDepartement(dep);
	}
    
}
