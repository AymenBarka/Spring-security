package com.example.campany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campany.entities.Departement;

@Repository("DepartementRepository")
public interface DepartementRepository extends JpaRepository<Departement, Integer>{

}
