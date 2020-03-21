package com.example.campany.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="entreprise")

public class Entreprise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_entreprise;
	
	@Column(name="name_entreprise")
	private String name_entreprise;
	
	@OneToMany(mappedBy=("ent"))
	@JsonIgnoreProperties("ent")
	private List<Employee>employees;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnoreProperties("entreprises")
	@JoinTable(
			name="Ent_Dept",
	joinColumns = {
			@JoinColumn(name="Ent_ID")
	},
	inverseJoinColumns= {
			@JoinColumn(name="Dept_ID")
			
	}
			)
	
	private List <Departement> departement;
	public Entreprise() {
	}
	
	public String getName_entreprise() {
		return name_entreprise;
	}

	public void setName_entreprise(String name_entreprise) {
		this.name_entreprise = name_entreprise;
	}

	public List<Departement> getDepartement() {
		return departement;
	}

	public void setDepartement(List<Departement> departement) {
		this.departement = departement;
	}

	public int getId_entreprise() {
		return id_entreprise;
	}
	public void setId_entreprise(int id_entreprise) {
		this.id_entreprise = id_entreprise;
	}
	public String getNom() {
		return name_entreprise;
	}
	public void setNom(String nom) {
		this.name_entreprise = nom;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Entreprise [id_entreprise=" + id_entreprise + ", name_entreprise=" + name_entreprise + ", employees="
				+ employees + ", departement=" + departement + "]";
	}
	

}
