package com.example.campany.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
@Table(name = "departement")
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_departement;
	
	@Column(name = "name_departement")
	private String name_departement;
	@OneToMany(mappedBy="dept")//mappedBy pour ne pas créer une troisieme table pour faire la liaison,et pour avoir une clé étrangere au table Employee
	@JsonIgnoreProperties("dept")
	private List<Employee>employees;
	@ManyToMany(mappedBy="departement", cascade = {CascadeType.ALL})
	@JsonIgnoreProperties(value="departement")
	private List<Entreprise>entreprises;

	public Departement() {

	}
	
	public List<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getId_departement() {
		return id_departement;
	}

	public void setId_departement(int id_departement) {
		this.id_departement = id_departement;
	}

	public String getName_departement() {
		return name_departement;
	}

	public void setName_departement(String name_departement) {
		this.name_departement = name_departement;
	}

	@Override
	public String toString() {
		return "Departement [id_departement=" + id_departement + ", name_departement=" + name_departement
				+ ", employees=" + employees + ", entreprises=" + entreprises + "]";
	}
	
	
	
	
}
