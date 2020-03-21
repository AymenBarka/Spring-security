package com.example.campany.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employe")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private  int id_employee;
	
	@Column(name= "nom")
	private String nom;
	
	@Column(name= "prenom")
	private String prenom ;
	@ManyToOne
	@JoinColumn(name="DEPT_ID")//veut dire d'appler la clé étrangere DEP_ID
	@JsonIgnoreProperties(value = "employees")
	private Departement dept;
	@ManyToOne
	@JoinColumn(name="ENT_ID")
	@JsonIgnoreProperties(value = "employees")

	private Entreprise ent;
	
	public Employee() {
		
	}
   
	public Departement getDept() {
		return dept;
	}

	public void setDept(Departement dept) {
		this.dept = dept;
	}

	public int getId_employee() {
		return id_employee;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Entreprise getEnt() {
		return ent;
	}

	public void setEnt(Entreprise ent) {
		this.ent = ent;
	}

	@Override
	public String toString() {
		return "Employee [id_employee=" + id_employee + ", nom=" + nom + ", prenom=" + prenom + ", dept=" + dept
				+ ", ent=" + ent + "]";
	}

	
}
