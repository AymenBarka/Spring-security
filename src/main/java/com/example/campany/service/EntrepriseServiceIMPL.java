package com.example.campany.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campany.entities.Departement;
import com.example.campany.entities.Entreprise;
import com.example.campany.repositories.DepartementRepository;
import com.example.campany.repositories.EntrepriseRepository;

@Service
@Transactional
public class EntrepriseServiceIMPL implements EntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public void addEntreprise(Entreprise ste) {
		entrepriseRepository.save(ste);
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise ste, int id) {

		Entreprise entrep= entrepriseRepository.findById(id).orElse(null);		
		entrep.setNom(ste.getNom());
		return entrepriseRepository.save(entrep);
	}

	@Override
	public String deleteEntreprise(int ste) {
		Optional<Entreprise> ent= entrepriseRepository.findById(ste);
		if(ent.isPresent()) {
			entrepriseRepository.delete(ent.get()); 
			return "entreprise is deleted by id "+ ent;
	}
		throw new RuntimeException("Not found Entreprise");
	}

	@Override
	public Entreprise getEntreprise(int id_entreprise) {
		return entrepriseRepository.findById(id_entreprise).get();
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		return entrepriseRepository.findAll();
	}

	@Override
	public void affectEntToDept(int idEnt, int idDept) {
		Entreprise entre = entrepriseRepository.findById(idEnt).get();
		Departement depart= departementRepository.findById(idDept).get();
		List<Entreprise> liste = depart.getEntreprises();
		liste.add(entre);
		depart.setEntreprises(liste);
		List<Departement>dept= entre.getDepartement();
		dept.add(depart);
		entre.setDepartement(dept);
		departementRepository.save(depart);
		entrepriseRepository.save(entre);
		
	}

}
