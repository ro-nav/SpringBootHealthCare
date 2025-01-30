package com.knowit.SpringBootHealthCare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knowit.SpringBootHealthCare.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
