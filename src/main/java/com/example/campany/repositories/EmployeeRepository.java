package com.example.campany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campany.entities.Employee;


@Repository("EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
