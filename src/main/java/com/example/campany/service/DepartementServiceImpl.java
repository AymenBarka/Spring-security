package com.example.campany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campany.entities.Departement;
import com.example.campany.entities.Entreprise;
import com.example.campany.repositories.DepartementRepository;
import com.example.campany.repositories.EntrepriseRepository;

@Service
@Transactional
public class DepartementServiceImpl implements DepartementService{

	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	@Override
	public void addDepartement(Departement dep) {
		departementRepository.save(dep);
		
	}

	@Override
	public Departement updateDepartement(Departement dep) {
		
		Departement depart= departementRepository.findById(dep.getId_departement()).orElse(null);		
		depart.setName_departement(dep.getName_departement());	
		return departementRepository.save(depart);
	}

	@Override
	public String deleteDepartement(int dep) {
		Optional<Departement> dept = departementRepository.findById(dep);
		if(dept.isPresent()) {
			departementRepository.delete(dept.get()); 
			return "departement is deleted by id "+ dep;
		}
		throw new RuntimeException("Not found Departement");
	}

	@Override
	public Departement getDepartement(int dep) {
		
		return departementRepository.findById(dep).get();
	}

	@Override
	public List<Departement> getAllDepartement() {
		
		return departementRepository.findAll();
	}

	
	


}
