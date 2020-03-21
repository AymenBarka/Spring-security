package com.example.campany.service;

import java.util.List;

import com.example.campany.entities.Departement;

public interface DepartementService {
	
	public void addDepartement(Departement dep);
	public Departement updateDepartement(Departement dep);
	public String deleteDepartement(int dep);
	public Departement getDepartement(int dep);
	public List<Departement> getAllDepartement();


}
