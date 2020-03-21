package com.example.campany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campany.entities.Entreprise;
@Repository("EntrepriseRepository")

public interface EntrepriseRepository extends JpaRepository<Entreprise , Integer> {

}
