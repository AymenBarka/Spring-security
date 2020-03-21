package com.example.campany.service;

import java.util.List;

import com.example.campany.entities.Entreprise;

public interface EntrepriseService {
	public void addEntreprise(Entreprise ste);
	public Entreprise updateEntreprise(Entreprise ste, int id);
	public String deleteEntreprise(int id_entreprise);
	public Entreprise getEntreprise(int id_entreprise);
	public List<Entreprise> getAllEntreprise();
	public void affectEntToDept(int idEnt, int idDept);

}
