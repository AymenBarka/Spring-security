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

import com.example.campany.entities.Entreprise;
import com.example.campany.service.DepartementService;
import com.example.campany.service.EntrepriseService;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value="/entreprises")
public class EntrepriseController {
	@Autowired
     EntrepriseService entrepriseService;
	@Autowired
	 DepartementService departementService;
	
    @PostMapping("/addEntreprise")
	public void addEntreprise(@RequestBody Entreprise ste) {
		entrepriseService.addEntreprise(ste);
	}
    
    @PutMapping("/updateEntreprise/{id}")
	public Entreprise updateEntreprise(@RequestBody Entreprise ste, @PathVariable (value="id") int id) {
		return entrepriseService.updateEntreprise(ste,id);
	}
    
    @DeleteMapping("/deleteEntreprise/{id}")
	public String deleteEntreprise(@PathVariable (value="id") int ste) {
		return entrepriseService.deleteEntreprise(ste);
	}
    @GetMapping("/getEntreprise/{id}")
	public Entreprise getEntreprise(@PathVariable (value= "id") int id_entreprise) {
		return entrepriseService.getEntreprise(id_entreprise);
	}
    
    @GetMapping("/getEntreprise")
	public List<Entreprise> getAllEntreprise() {
		return entrepriseService.getAllEntreprise();
	}
	
    @GetMapping("/affectEntreprise/{idEnt}/{idDept}")
   	public void affectEntToDept(@PathVariable(value="idEnt")int idEnt,@PathVariable(value="idDept") int idDept) {
   		entrepriseService.affectEntToDept(idEnt, idDept);
   	}

}
